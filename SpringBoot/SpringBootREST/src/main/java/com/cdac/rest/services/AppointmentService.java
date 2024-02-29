package com.cdac.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.rest.entities.Appointment;
import com.cdac.rest.entities.DoctorRegistrationEntity;
import com.cdac.rest.entities.PatientRegistrationEntity;
import com.cdac.rest.repositories.AppointmentRepository;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment saveAppointment(Appointment appointment) {
    	appointment.setStatus("Not Visited");
    	
        return appointmentRepository.save(appointment);
    }
    
    public Appointment saveUpdateAppointment(Appointment appointment) { 	
        return appointmentRepository.save(appointment);
    }
    
    public List<Appointment> getAppointmentsByDoctorIdAndDate(DoctorRegistrationEntity doctorId, String appointmentDate) {
        return appointmentRepository.findByDoctorIdAndAppointmentDate(doctorId, appointmentDate);
    }
    
    public Appointment getAppointmentById(Integer appointmentId) {
        return appointmentRepository.findById(appointmentId).orElse(null);
    }
    
    public List<Appointment> getAppointmentsByPatientId(PatientRegistrationEntity patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
    
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    
    public List<Appointment> getAppointmentsByDoctorLoginId(DoctorRegistrationEntity doctorLoginId){
    	return appointmentRepository.findByDoctorId(doctorLoginId);
    }
}
