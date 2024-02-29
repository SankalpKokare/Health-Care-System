package com.cdac.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.rest.entities.AppointmentTime;

@Repository
public interface AppointmentTimeRepository extends JpaRepository<AppointmentTime, Integer> {
	
	 List<AppointmentTime> findByDoctorIdAndDay(Integer doctorId, String day);
	 List<AppointmentTime> findByDoctorIdAndSlotStartAndDay(Integer doctorId, String slotStart, String day);
}
