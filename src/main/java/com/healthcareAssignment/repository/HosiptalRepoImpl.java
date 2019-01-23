package com.healthcareAssignment.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.healthcareAssignment.entity.Hospital;

@Transactional
@Repository
public class HosiptalRepoImpl implements HosiptalRepo {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Hospital save(Hospital hospitalData) {
		Hospital objHospital = null;
		try {
			objHospital = entityManager.merge(hospitalData);

		} catch (Exception e) {
			System.out.println("exception" + objHospital);
		} finally {
			entityManager.flush();
			entityManager.clear();
		}
		return objHospital;
	}

	@Override
	public Hospital delete(Integer id) {
		Hospital objEntity = null;
		try {
			objEntity = entityManager.find(Hospital.class, id);
			entityManager.remove(objEntity);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.flush();
			entityManager.clear();
		}

		return objEntity;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Hospital> searchData() {
		List<Hospital> objEntity = null;
		try {

//			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//			CriteriaQuery<Hospital> query = cb.createQuery(Hospital.class);
//			Root<Hospital> root = query.from(Hospital.class);
//			query.select(root);
//			query.where(cb.equal(root.get("customerId"), customerId));
//			query.orderBy(cb.asc(root.get("useCaseName")));
//			TypedQuery<Hospital> typedQuery = entityManager.createQuery(query);
//			useCaseBuilderEntityList = typedQuery.getResultList();

			
			Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Hospital.class);
			objEntity = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.flush();
			entityManager.clear();
		}

		return objEntity;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public Hospital searchDataById(Integer id) {
		Hospital objEntity = null;
		try {


			
			Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Hospital.class);
			criteria.add(Restrictions.eq("id", id));
			objEntity =(Hospital) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.flush();
			entityManager.clear();
		}

		return objEntity;
	}


}
