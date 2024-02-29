package com.cdac.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.rest.entities.AppointmentPatientAssociationEntity;

@Repository
public interface AppointmentPatRepository extends JpaRepository<AppointmentPatientAssociationEntity,Integer> {
	
    List<AppointmentPatientAssociationEntity> findByDoctorIdAndAppointmentDate(Integer doctorId, String appointmentDate);
}