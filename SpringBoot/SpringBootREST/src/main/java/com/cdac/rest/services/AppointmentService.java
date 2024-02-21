package com.cdac.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.rest.entities.Appointment;
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
    
    public List<Appointment> getAppointmentsByDoctorIdAndDate(Integer doctorId, String appointmentDate) {
        return appointmentRepository.findByDoctorIdAndAppointmentDate(doctorId, appointmentDate);
    }
}