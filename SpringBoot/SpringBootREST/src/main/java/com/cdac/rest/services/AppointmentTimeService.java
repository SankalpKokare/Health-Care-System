package com.cdac.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.rest.entities.AppointmentTime;
import com.cdac.rest.repositories.AppointmentTimeRepository;

@Service
public class AppointmentTimeService {
    @Autowired
    private AppointmentTimeRepository appointmentTimeRepository;

    public AppointmentTime saveAppointmentTime(AppointmentTime appointmentTime) {
        return appointmentTimeRepository.save(appointmentTime);
    }
    
    public List<AppointmentTime> getAppointmentTimesByDoctorAndDate(Integer doctorId, String date) {
        return appointmentTimeRepository.findByDoctorIdAndDay(doctorId, date);
    }
    public List<AppointmentTime> getAppointmentTimesByDoctorSlotAndDate(Integer doctorId, String slotStart, String date) {
        return appointmentTimeRepository.findByDoctorIdAndSlotStartAndDay(doctorId, slotStart, date);
    }
    
    public void saveAllAppointmentTimes(List<AppointmentTime> appointmentTimes) {
        appointmentTimeRepository.saveAll(appointmentTimes);
    }
}
