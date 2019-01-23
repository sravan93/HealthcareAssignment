package com.healthcareAssignment.repository;

import java.util.List;

import com.healthcareAssignment.entity.Hospital;

public interface HosiptalRepo{

	Hospital save( Hospital hospitalData);

	Hospital delete(Integer id);

	List<Hospital> searchData();
	 Hospital searchDataById(Integer id);

		

}
