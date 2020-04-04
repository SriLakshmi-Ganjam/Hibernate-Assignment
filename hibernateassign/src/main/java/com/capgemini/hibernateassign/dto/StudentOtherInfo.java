package com.capgemini.hibernateassign.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="student_otherinfo")
public class StudentOtherInfo implements Serializable{

	@Id
	private int rollNumber;
	@Column
	private String fathername;
	@Column
	private String mothername;
	@Column
	private String religion;
	@Column
	private String nationality;
	@MapsId
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rollNumber")
	private StudentInfo info;
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public StudentInfo getInfo() {
		return info;
	}
	public void setInfo(StudentInfo info) {
		this.info = info;
	}
}