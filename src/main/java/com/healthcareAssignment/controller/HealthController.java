/**
 * 
 */
package com.healthcareAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.healthcareAssignment.Individualentity.ExaminationnewEntity;
import com.healthcareAssignment.Individualentity.HospitalnewEntity;
import com.healthcareAssignment.Individualentity.PatientnewEntity;
import com.healthcareAssignment.dto.HospitalDto;
import com.healthcareAssignment.entity.Hospital;
import com.healthcareAssignment.individualmodels.ExaminationnewModel;
import com.healthcareAssignment.individualmodels.HospitalnewModel;
import com.healthcareAssignment.individualmodels.PatientnewModel;
import com.healthcareAssignment.models.HospitalModel;
import com.healthcareAssignment.service.HosiptalService;

@RestController
public class HealthController {

	@Autowired
	private HosiptalService hosiptalService;

	@RequestMapping(value = "/createHospitalData", method = RequestMethod.POST)
	public Hospital createHospitalData(@RequestBody HospitalModel hospitalData) {

		System.out.println("hospitalData......." + hospitalData);
		Hospital objHospital = HospitalDto.hospitalModelToEntity(hospitalData);
		Hospital createHospitalData = hosiptalService.createHospitalData(objHospital);

		return createHospitalData;

	}

	@RequestMapping(value = "/updateHospitalData", method = RequestMethod.POST)
	public Hospital updateHospitalData(@RequestBody HospitalModel hospitalData) {

		System.out.println("hospitalData......." + hospitalData);
		Hospital objHospital = HospitalDto.hospitalModelToEntity(hospitalData);

		return hosiptalService.createHospitalData(objHospital);

	}

	@RequestMapping(value = "/deleteHospitalData", method = RequestMethod.POST)
	public Hospital deleteHospitalData(@RequestBody HospitalModel hospitalData) {

		return hosiptalService.deleteHospitalData(hospitalData.getId());

	}

	@RequestMapping(value = "/searchData", method = RequestMethod.POST)
	public List<Hospital> searchData(@RequestBody HospitalModel hospitalData) {

		return hosiptalService.searchData();

	}

	@RequestMapping(value = "/searchDataByID", method = RequestMethod.POST)
	public Hospital searchDataByID(@RequestBody HospitalModel hospitalData) {

		return hosiptalService.searchDataById(hospitalData.getId());

	}

	@RequestMapping(value = "/createHospitalDataOnly", method = RequestMethod.POST)
	public HospitalnewEntity createHospitalData(@RequestBody HospitalnewModel hospitalData) {

		HospitalnewEntity objHospital = HospitalDto.newhospitalModelToEntity(hospitalData);
		HospitalnewEntity createHospitalData = hosiptalService.createnewHospitalData(objHospital);

		return createHospitalData;

	}

	@RequestMapping(value = "/createPatientDataOnly", method = RequestMethod.POST)
	public PatientnewEntity createPatientDataOnly(@RequestBody PatientnewModel ibjPatientnewModel) {

		PatientnewEntity objPatientnewEntity = HospitalDto.newpatientModelToEntity(ibjPatientnewModel);
		PatientnewEntity createPatientnewEntity = hosiptalService.createnewPatientData(objPatientnewEntity);

		return createPatientnewEntity;

	}

	@RequestMapping(value = "/createExaminationDataOnly", method = RequestMethod.POST)
	public ExaminationnewEntity createExaminationDataOnly(@RequestBody ExaminationnewModel objExaminationnewModel) {

		ExaminationnewEntity objExaminationnewEntity = HospitalDto.newExamiModelToEntity(objExaminationnewModel);
		ExaminationnewEntity createExaminationnewEntity = hosiptalService.createnewExaminaData(objExaminationnewEntity);

		return createExaminationnewEntity;

	}

	@RequestMapping(value = "/searchByHospital", method = RequestMethod.POST)
	public List<HospitalnewEntity> searchByHospital(@RequestBody HospitalnewModel hospitalData) {

		return hosiptalService.searchByHospital();

	}

	@RequestMapping(value = "/searchByPatient", method = RequestMethod.POST)
	public List<PatientnewModel> searchByPatient(@RequestBody PatientnewModel patientModel) {

		return hosiptalService.searchByPatient(patientModel);

	}

	@RequestMapping(value = "/searchByExamination", method = RequestMethod.POST)
	public List<ExaminationnewModel> searchByExamination(@RequestBody ExaminationnewModel objExaminationnewModel) {

		return hosiptalService.searchByExamination(objExaminationnewModel);

	}
	
	@RequestMapping(value = "/updateHospitalDataOnly", method = RequestMethod.POST)
	public HospitalnewEntity updateHospitalDataOnly(@RequestBody HospitalnewModel hospitalData) {

		HospitalnewEntity objHospital = HospitalDto.newhospitalModelToEntity(hospitalData);
		HospitalnewEntity createHospitalData = hosiptalService.createnewHospitalData(objHospital);

		return createHospitalData;

	}

	@RequestMapping(value = "/updatePatientDataOnly", method = RequestMethod.POST)
	public PatientnewEntity updatePatientDataOnly(@RequestBody PatientnewModel ibjPatientnewModel) {

		PatientnewEntity objPatientnewEntity = HospitalDto.newpatientModelToEntity(ibjPatientnewModel);
		PatientnewEntity createPatientnewEntity = hosiptalService.createnewPatientData(objPatientnewEntity);

		return createPatientnewEntity;

	}

	@RequestMapping(value = "/updateExaminationDataOnly", method = RequestMethod.POST)
	public ExaminationnewEntity updateExaminationDataOnly(@RequestBody ExaminationnewModel objExaminationnewModel) {

		ExaminationnewEntity objExaminationnewEntity = HospitalDto.newExamiModelToEntity(objExaminationnewModel);
		ExaminationnewEntity createExaminationnewEntity = hosiptalService.createnewExaminaData(objExaminationnewEntity);

		return createExaminationnewEntity;

	}
	
	

	@RequestMapping(value = "/deleteHospitalDataOnly", method = RequestMethod.POST)
	public HospitalnewEntity deleteHospitalDataOnly(@RequestBody HospitalnewModel hospitalData) {


		return hosiptalService.deleteHospitalDataOnly(hospitalData.getId());

	}

	@RequestMapping(value = "/deletePatientDataOnly", method = RequestMethod.POST)
	public PatientnewEntity deletePatientDataOnly(@RequestBody PatientnewModel ibjPatientnewModel) {

		return hosiptalService.deletePatientDataOnly(ibjPatientnewModel.getPatient_id());

	}

	@RequestMapping(value = "/deleteExaminationDataOnly", method = RequestMethod.POST)
	public ExaminationnewEntity deleteExaminationDataOnly(@RequestBody ExaminationnewModel objExaminationnewModel) {

		return hosiptalService.deleteExaminationDataOnly(objExaminationnewModel.getEx_id());

	}
	

}
