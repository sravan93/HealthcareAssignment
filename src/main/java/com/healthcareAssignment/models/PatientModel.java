package com.healthcareAssignment.models;

import java.io.Serializable;
import java.util.List;

public class PatientModel implements Serializable {

	private static final long serialVersionUID = 1479394391426816314L;
	private Integer patient_id;
	private String patient_Name;
	private String dateOfBirth;
	private String gender;

	private List<ExaminationModel> exmination;

	public Integer getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_Name() {
		return patient_Name;
	}

	public void setPatient_Name(String patient_Name) {
		this.patient_Name = patient_Name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<ExaminationModel> getExmination() {
		return exmination;
	}

	public void setExmination(List<ExaminationModel> exmination) {
		this.exmination = exmination;
	}

}
