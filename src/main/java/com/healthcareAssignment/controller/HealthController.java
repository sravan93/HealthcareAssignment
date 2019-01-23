/**
 * 
 */
package com.healthcareAssignment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.healthcareAssignment.dto.HospitalDto;
import com.healthcareAssignment.entity.Hospital;
import com.healthcareAssignment.models.HospitalModel;
import com.healthcareAssignment.service.HosiptalService;

@RestController
public class HealthController {

	@Autowired
	private HosiptalService hosiptalService;


	
	@RequestMapping(value = "/createHospitalData", method = RequestMethod.POST)	
	public Hospital createHospitalData( @RequestBody HospitalModel hospitalData) {

		System.out.println("hospitalData......." + hospitalData);
		Hospital objHospital=HospitalDto.hospitalModelToEntity(hospitalData);
		Hospital createHospitalData = hosiptalService.createHospitalData(objHospital);
		  
		return createHospitalData;

	}
	
	@RequestMapping(value = "/updateHospitalData", method = RequestMethod.POST)	
	public Hospital updateHospitalData( @RequestBody HospitalModel hospitalData) {

		System.out.println("hospitalData......." + hospitalData);
		Hospital objHospital=HospitalDto.hospitalModelToEntity(hospitalData);
		
		return hosiptalService.createHospitalData(objHospital);

	}
	
	@RequestMapping(value = "/deleteHospitalData", method = RequestMethod.POST)	
	public Hospital deleteHospitalData(  @RequestBody HospitalModel hospitalData) {
		
		return hosiptalService.deleteHospitalData(hospitalData.getId());

	}
	

	@RequestMapping(value = "/searchData", method = RequestMethod.POST)	
	public List<Hospital> searchData(  @RequestBody  HospitalModel hospitalData ) {
		
		return hosiptalService.searchData();

	}
	
	@RequestMapping(value = "/searchDataByID", method = RequestMethod.POST)	
	public Hospital searchDataByID(  @RequestBody  HospitalModel hospitalData ) {
		
		return hosiptalService.searchDataById(hospitalData.getId());

	}
	
	

}
