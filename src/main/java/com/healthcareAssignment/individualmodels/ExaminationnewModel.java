package com.healthcareAssignment.individualmodels;

public class ExaminationnewModel {
	
	private Integer ex_id;
	private String examDate;
	private String ex_name;
	private String ex_Description;
	
	
	private Integer hospitalId;
	private String hospitalName;
	

	private Integer patientId;
	private String patientName;

	private String weight;
	private String height;
	

	public Integer getEx_id() {
		return ex_id;
	}

	public void setEx_id(Integer ex_id) {
		this.ex_id = ex_id;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getEx_name() {
		return ex_name;
	}

	public void setEx_name(String ex_name) {
		this.ex_name = ex_name;
	}

	public String getEx_Description() {
		return ex_Description;
	}

	public void setEx_Description(String ex_Description) {
		this.ex_Description = ex_Description;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	
	
}
