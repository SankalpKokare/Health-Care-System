package com.cdac.rest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class DoctorRegistrationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int doctorid;
	@Column
	String first_name;
	@Column
	String last_name;
	@Column
	String address;
	@Column
	String city;
	@Column
	String state;
	@Column
	String pincode;
	@Column
	String phonenumber;
	@Column
	String email;
	@Column
	String gender;
	@Column
	String description;
	@Column
	String image;
	@Column
	String specialization;
	@Column
	String education;
	
	@OneToOne
	@JoinColumn(name="doctor_login_id")
	LoginEntity doctor_login_id;
	
	public DoctorRegistrationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public DoctorRegistrationEntity( String first_name, String last_name, String address, String city,
			String state, String pincode, String phonenumber, String email, String gender, String description, String image,
			String specialization, String education, LoginEntity doctor_login_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.phonenumber = phonenumber;
		this.email = email;
		this.gender = gender;
		this.description = description;
		this.image = image;
		this.specialization = specialization;
		this.education = education;
		this.doctor_login_id = doctor_login_id;
	}


	public int getDoctorid() {
		return doctorid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPincode() {
		return pincode;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	public String getSpecialization() {
		return specialization;
	}

	public String getEducation() {
		return education;
	}


	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public void setEducation(String education) {
		this.education = education;
	}


	public LoginEntity getDoctor_login_id() {
		return doctor_login_id;
	}


	public void setDoctor_login_id(LoginEntity doctor_login_id) {
		this.doctor_login_id = doctor_login_id;
	}

	
	@Override
	public String toString() {
		return "DoctorRegistrationEntity [doctorid=" + doctorid + ", first_name=" + first_name + ", last_name="
				+ last_name + ", address=" + address + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", phonenumber=" + phonenumber + ", email=" + email + ", gender=" + gender + ", description="
				+ description + ", image=" + image + ", specialization=" + specialization + ", education=" + education
				+ ", doctor_login_id=" + doctor_login_id + "]";
	}
}
