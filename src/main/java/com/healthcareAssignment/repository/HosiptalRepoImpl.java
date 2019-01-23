package com.healthcareAssignment.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.healthcareAssignment.Individualentity.ExaminationnewEntity;
import com.healthcareAssignment.Individualentity.HospitalnewEntity;
import com.healthcareAssignment.Individualentity.PatientnewEntity;
import com.healthcareAssignment.entity.Hospital;
import com.healthcareAssignment.individualmodels.ExaminationnewModel;
import com.healthcareAssignment.individualmodels.PatientnewModel;

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

			// CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			// CriteriaQuery<Hospital> query = cb.createQuery(Hospital.class);
			// Root<Hospital> root = query.from(Hospital.class);
			// query.select(root);
			// query.where(cb.equal(root.get("customerId"), customerId));
			// query.orderBy(cb.asc(root.get("useCaseName")));
			// TypedQuery<Hospital> typedQuery =
			// entityManager.createQuery(query);
			// useCaseBuilderEntityList = typedQuery.getResultList();

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

	@SuppressWarnings({ "deprecation" })
	@Override
	public Hospital searchDataById(Integer id) {
		Hospital objEntity = null;
		try {

			Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Hospital.class);
			criteria.add(Restrictions.eq("id", id));
			objEntity = (Hospital) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.flush();
			entityManager.clear();
		}

		return objEntity;
	}

	@Override
	public HospitalnewEntity createnewHospitalData(HospitalnewEntity hospitalData) {
		HospitalnewEntity objHospital = null;
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
	public PatientnewEntity createnewPatientData(PatientnewEntity patientData) {
		PatientnewEntity objPatientnewEntity = null;
		try {
			objPatientnewEntity = entityManager.merge(patientData);

		} catch (Exception e) {
			System.out.println("exception" + objPatientnewEntity);
		} finally {
			entityManager.flush();
			entityManager.clear();
		}
		return objPatientnewEntity;
	}

	@Override
	public ExaminationnewEntity createnewExaminaData(ExaminationnewEntity examinationData) {
		ExaminationnewEntity objExaminationnewEntity = null;
		try {
			objExaminationnewEntity = entityManager.merge(examinationData);

		} catch (Exception e) {
			System.out.println("exception" + objExaminationnewEntity);
		} finally {
			entityManager.flush();
			entityManager.clear();
		}
		return objExaminationnewEntity;
	}

	@Override
	public List<HospitalnewEntity> searchByHospital() {
		// TODO Auto-generated method stub
		List<HospitalnewEntity> objList = null;

		try {
			
			Criteria criteria = entityManager.unwrap(Session.class).createCriteria(HospitalnewEntity.class);
			objList =  criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.flush();
			entityManager.clear();
		}
		return objList;
	}

	@Override
	public List<PatientnewModel> searchByPatient(PatientnewModel patientModel) {
		List<PatientnewEntity> objList = null;
		List<PatientnewModel> objNewModel=new ArrayList<>();
		try {
			Criteria criteria = entityManager.unwrap(Session.class).createCriteria(PatientnewEntity.class);
			criteria.createAlias("hospital", "hospital");
			criteria.add(Restrictions.eq("hospital.id", patientModel.getHospitalId()));
			objList =  criteria.list();
			
			if(objList!=null && objList.size()>0){
				for(PatientnewEntity objLocPatientnewEntity:objList){
					PatientnewModel objPatientnewModel=new PatientnewModel();
					objPatientnewModel.setPatient_id(objLocPatientnewEntity.getPatient_id());
					objPatientnewModel
					.setDateOfBirth(objLocPatientnewEntity.getDateOfBirth().toString());
					objPatientnewModel.setGender(objLocPatientnewEntity.getGender());

					objPatientnewModel.setPatient_Name(objLocPatientnewEntity.getPatient_Name());
					objPatientnewModel.setAge(objLocPatientnewEntity.getAge());
					objPatientnewModel.setHospitalName(objLocPatientnewEntity.getHospital().getHospital_Name());
					objPatientnewModel.setHospitalId(objLocPatientnewEntity.getHospital().getId());
					//objPatientnewModel.setGenerateDate(objLocPatientnewEntity.getGenerateDate().toString());
					objNewModel.add(objPatientnewModel);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.flush();
			entityManager.clear();
		}
		return objNewModel;
	}

	@Override
	public List<ExaminationnewModel> searchByExamination(ExaminationnewModel objExaminationnewModel) {
		List<ExaminationnewEntity> objList = null;
		List<ExaminationnewModel>  objLOcList=new ArrayList<>();
		try {
			
			Criteria criteria = entityManager.unwrap(Session.class).createCriteria(ExaminationnewEntity.class);
			criteria.createAlias("hospital", "hospital");
			criteria.createAlias("patient", "patient");
			criteria.add(Restrictions.eq("hospital.id", objExaminationnewModel.getHospitalId()));
			criteria.add(Restrictions.eq("patient.patient_id", objExaminationnewModel.getPatientId()));
			objList =  criteria.list();
			if(objList!=null && objList.size()>0){
				
				for(ExaminationnewEntity objExaminationnewEntity:objList){
					ExaminationnewModel objnewExaminationnewModel=new ExaminationnewModel();
					objnewExaminationnewModel.setEx_id(objExaminationnewEntity.getEx_id());
					objnewExaminationnewModel.setEx_name(objExaminationnewEntity.getEx_name());
					objnewExaminationnewModel.setEx_Description(objExaminationnewEntity.getEx_Description());
					objnewExaminationnewModel.setExamDate(objExaminationnewEntity.getExamDate().toString());
					objnewExaminationnewModel.setPatientName(objExaminationnewEntity.getPatient().getPatient_Name());
					objnewExaminationnewModel.setPatientId(objExaminationnewEntity.getPatient().getPatient_id());
					objnewExaminationnewModel.setHospitalName(objExaminationnewEntity.getHospital().getHospital_Name());
					objnewExaminationnewModel.setHospitalId(objExaminationnewEntity.getHospital().getId());
					objLOcList.add(objnewExaminationnewModel);
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.flush();
			entityManager.clear();
		}
		return objLOcList;
	}

}
