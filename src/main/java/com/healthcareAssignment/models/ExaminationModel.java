package com.healthcareAssignment.models;

public class ExaminationModel {
	
	private int ex_id;
	private String examDate;
	private String ex_name;
	private String ex_Description;

	public int getEx_id() {
		return ex_id;
	}

	public void setEx_id(int ex_id) {
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
}
