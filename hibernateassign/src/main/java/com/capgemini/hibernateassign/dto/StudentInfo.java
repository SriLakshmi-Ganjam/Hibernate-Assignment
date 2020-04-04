package com.capgemini.hibernateassign.dto;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import com.capgemini.hibernateassignment.onetoone.StudentOtherInfo;

import lombok.Data;
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="student_info")
public class StudentInfo implements Serializable{
	@Id
	@Column
	private int rollNumber;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String gender;
	@Column
	private long mobileNumber;
	@Column
	private String emailId;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "info")
	private StudentOtherInfo otherInfo;
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public StudentOtherInfo getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(StudentOtherInfo otherInfo) {
		this.otherInfo = otherInfo;
	}
	
}