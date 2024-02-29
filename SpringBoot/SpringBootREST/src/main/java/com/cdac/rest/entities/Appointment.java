package com.cdac.rest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ap_id")
    private Integer id;

    @ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientRegistrationEntity patientId;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorRegistrationEntity doctorId;

    @Column(name = "appointment_date")
    private String appointmentDate;

    @Column(name = "appointment_time")
    private String appointmentTime;

    @Column(name = "notes")
    private String notes;

    @Column(name = "status")
    private String status;

    @Column(name="prescription")
    private String prescription;
    
    
    

	public Appointment() {
		super();
	}
	
	
	

	public Appointment(PatientRegistrationEntity patientId, DoctorRegistrationEntity doctorId, String appointmentDate,
			String appointmentTime, String notes) {
		super();
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.notes = notes;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PatientRegistrationEntity getPatientId() {
		return patientId;
	}

	public void setPatientId(PatientRegistrationEntity patientId) {
		this.patientId = patientId;
	}

	public DoctorRegistrationEntity getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(DoctorRegistrationEntity doctorId) {
		this.doctorId = doctorId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	
	
}
