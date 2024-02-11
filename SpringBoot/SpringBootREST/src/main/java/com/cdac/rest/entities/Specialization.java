package com.cdac.rest.entities;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;*/

import jakarta.annotation.Generated;

/*import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;*/



//@Entit
//@Entity
//@Table(name="speciailization")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@jakarta.persistence.Entity
@jakarta.persistence.Table(name="specialization")


public class Specialization 
{
	@jakarta.persistence.Id
	//@GeneratedValue(strategy =GenerationType.IDENTITY)
	@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	int spid;
	@jakarta.persistence.Column
	String specialization;
	
	public int getSpid() {
		return spid;
	}
	public void setSpid(int spid) {
		this.spid = spid;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	@Override
	public String toString() {
		return "Specialization [spid=" + spid + ", specialization=" + specialization + "]";
	}
	public Specialization(int spid, String specialization) {
		super();
		this.spid = spid;
		this.specialization = specialization;
	}
	public Specialization() {
		super();
	}
	

}
