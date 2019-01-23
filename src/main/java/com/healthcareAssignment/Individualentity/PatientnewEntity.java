package com.healthcareAssignment.Individualentity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "patientNew")
public class PatientnewEntity implements Serializable {

	private static final long serialVersionUID = 1479394391426816314L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patient_id;
	@NotNull
	@Column(name = "patient_Name")
	private String patient_Name;
	@NotNull
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;
	@NotNull
	@Column(name = "age")
	private String age;
	@NotNull
	@Column(name = "gender")
	private String gender;
	@NotNull
	@Column(name = "generateDate")
	private Date generateDate;

	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hospital_Id", referencedColumnName = "id")
	private HospitalnewEntity hospital;

	
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

	

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public HospitalnewEntity getHospital() {
		return hospital;
	}

	public void setHospital(HospitalnewEntity hospital) {
		this.hospital = hospital;
	}

	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getGenerateDate() {
		return generateDate;
	}

	public void setGenerateDate(Date generateDate) {
		this.generateDate = generateDate;
	}
	

}
