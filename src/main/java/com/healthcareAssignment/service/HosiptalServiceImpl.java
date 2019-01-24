package com.healthcareAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcareAssignment.Individualentity.ExaminationnewEntity;
import com.healthcareAssignment.Individualentity.HospitalnewEntity;
import com.healthcareAssignment.Individualentity.PatientnewEntity;
import com.healthcareAssignment.entity.Hospital;
import com.healthcareAssignment.individualmodels.ExaminationnewModel;
import com.healthcareAssignment.individualmodels.PatientnewModel;
import com.healthcareAssignment.repository.HosiptalRepo;

@Service
public class HosiptalServiceImpl implements HosiptalService {

	@Autowired
	private HosiptalRepo hosiptalRepo;
	
	@Override
	public Hospital createHospitalData(Hospital hospitalData) {
			
		
		return hosiptalRepo.save(hospitalData);
	}

	@Override
	public Hospital deleteHospitalData(Integer id) {
		
		return hosiptalRepo.delete(id);
	}

	@Override
	public List<Hospital> searchData() {
		// TODO Auto-generated method stub
		return hosiptalRepo.searchData();
	}

	@Override
	public Hospital searchDataById(Integer id) {
		// TODO Auto-generated method stub
		return hosiptalRepo.searchDataById(id);
	}

	@Override
	public List<HospitalnewEntity> searchByHospital() {
		// TODO Auto-generated method stub
		return hosiptalRepo.searchByHospital();
	}

	@Override
	public List<PatientnewModel> searchByPatient(PatientnewModel patientModel) {
		// TODO Auto-generated method stub
		return hosiptalRepo.searchByPatient(patientModel);
	}

	@Override
	public List<ExaminationnewModel> searchByExamination(ExaminationnewModel objExaminationnewModel) {
		// TODO Auto-generated method stub
		return hosiptalRepo.searchByExamination(objExaminationnewModel);
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public HospitalnewEntity createnewHospitalData(HospitalnewEntity hospitalData) {
			
		
		return hosiptalRepo.createnewHospitalData(hospitalData);
	}
	
	
	@Override
	public PatientnewEntity createnewPatientData(PatientnewEntity patientData) {
			
		
		return hosiptalRepo.createnewPatientData(patientData);
	}
	@Override
	public ExaminationnewEntity createnewExaminaData(ExaminationnewEntity examinationData) {
			
		
		return hosiptalRepo.createnewExaminaData(examinationData);
	}

	@Override
	public HospitalnewEntity deleteHospitalDataOnly(Integer id) {
		// TODO Auto-generated method stub
		return hosiptalRepo.deleteHospitalDataOnly(id);
	}

	@Override
	public PatientnewEntity deletePatientDataOnly(Integer patient_id) {
		// TODO Auto-generated method stub
		return hosiptalRepo.deletePatientDataOnly(patient_id);
	}

	@Override
	public ExaminationnewEntity deleteExaminationDataOnly(Integer ex_id) {
		// TODO Auto-generated method stub
		return hosiptalRepo.deleteExaminationDataOnly(ex_id);
	}
}
