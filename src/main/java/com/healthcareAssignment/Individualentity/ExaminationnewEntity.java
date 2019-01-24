package com.healthcareAssignment.Individualentity;

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
@Table(name = "examinationNew")
public class ExaminationnewEntity implements Serializable {

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
	
	@NotNull
	@Column(name = "weight")
	private String weight;
	@NotNull
	@Column(name = "height")
	private String height;
	
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
	private PatientnewEntity patient;

	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hospital_Id", referencedColumnName = "id")
	private HospitalnewEntity hospital;
	
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

	public PatientnewEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientnewEntity patient) {
		this.patient = patient;
	}

	public HospitalnewEntity getHospital() {
		return hospital;
	}

	public void setHospital(HospitalnewEntity hospital) {
		this.hospital = hospital;
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
