package com.healthcareAssignment.service;

import java.util.List;

import com.healthcareAssignment.entity.Hospital;

public interface HosiptalService {

	Hospital createHospitalData(Hospital hospitalData);

	Hospital deleteHospitalData(Integer id);

	List<Hospital> searchData();
	public Hospital searchDataById(Integer id);

	

	
}
