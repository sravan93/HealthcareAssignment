package com.healthcareAssignment.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "examination")
public class Examination implements Serializable {

	private static final long serialVersionUID = 8100474502767526972L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ex_id;

	@NotNull
	@Column(name = "examDate")
	private Date examDate;

	@NotNull
	@Column(name = "ex_name")
	private String ex_name;

	@NotNull
	@Column(name = "ex_Description")
	private String ex_Description;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "p_Id", referencedColumnName = "patient_id")
	private Patient patient;

	public int getEx_id() {
		return ex_id;
	}

	public void setEx_id(int ex_id) {
		this.ex_id = ex_id;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
