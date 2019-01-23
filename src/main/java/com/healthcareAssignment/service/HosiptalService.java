package com.healthcareAssignment.service;

import java.util.List;

import com.healthcareAssignment.Individualentity.ExaminationnewEntity;
import com.healthcareAssignment.Individualentity.HospitalnewEntity;
import com.healthcareAssignment.Individualentity.PatientnewEntity;
import com.healthcareAssignment.entity.Hospital;
import com.healthcareAssignment.individualmodels.ExaminationnewModel;
import com.healthcareAssignment.individualmodels.PatientnewModel;

public interface HosiptalService {

	Hospital createHospitalData(Hospital hospitalData);

	Hospital deleteHospitalData(Integer id);

	List<Hospital> searchData();

	Hospital searchDataById(Integer id);

	List<HospitalnewEntity> searchByHospital();

	List<PatientnewModel> searchByPatient(PatientnewModel patientModel);

	List<ExaminationnewModel> searchByExamination(ExaminationnewModel objExaminationnewModel);
	
	HospitalnewEntity createnewHospitalData(HospitalnewEntity hospitalData);

	PatientnewEntity createnewPatientData(PatientnewEntity patientData);

	ExaminationnewEntity createnewExaminaData(ExaminationnewEntity examinationData);

}
