package com.healthcareAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcareAssignment.entity.Hospital;
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

}
