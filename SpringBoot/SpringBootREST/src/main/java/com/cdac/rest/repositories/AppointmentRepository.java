package com.cdac.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.rest.entities.Appointment;
import com.cdac.rest.entities.DoctorRegistrationEntity;
import com.cdac.rest.entities.PatientRegistrationEntity;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
	
    List<Appointment> findByDoctorIdAndAppointmentDate(DoctorRegistrationEntity doctorId, String appointmentDate);
    
    List<Appointment>findByPatientId(PatientRegistrationEntity patientId);
    
    List<Appointment>findByDoctorId( DoctorRegistrationEntity doctorLoginId);

}
