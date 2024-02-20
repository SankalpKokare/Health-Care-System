package com.cdac.rest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="patient")
public class PatientRegistrationEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int patient_id;
	
	String first_name;
	String last_name;
	String address;
	long phone_number;
	String gender;
	String email_id;
	String city;
	String state;
	long pincode; 
	
	@OneToOne
	@JoinColumn(name="patient_login_id")
	LoginEntity patient_login_id;

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public LoginEntity getPatient_login_id() {
		return patient_login_id;
	}

	public void setPatient_login_id(LoginEntity patient_login_id) {
		this.patient_login_id = patient_login_id;
		
	}

	public PatientRegistrationEntity(String first_name, String last_name, String address, long phone_number,
			String gender, String email_id, String city, String state, long pincode, LoginEntity patient_login_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.phone_number = phone_number;
		this.gender = gender;
		this.email_id = email_id;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.patient_login_id = patient_login_id;
	}

	public PatientRegistrationEntity() {
		super();
	}
	
	

}
