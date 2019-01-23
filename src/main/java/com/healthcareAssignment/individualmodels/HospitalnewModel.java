package com.healthcareAssignment.individualmodels;

import java.io.Serializable;
import java.util.List;


public class HospitalnewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5590409333854335880L;
	private Integer id;
	private String hospital_Name;
	private String description;
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHospital_Name() {
		return hospital_Name;
	}

	public void setHospital_Name(String hospital_Name) {
		this.hospital_Name = hospital_Name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}
