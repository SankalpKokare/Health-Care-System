package com.cdac.rest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="specialization")


public class Specialization 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int spid;
	@Column
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
