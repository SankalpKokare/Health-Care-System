package com.cdac.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cdac.rest.entities.Appointment;
import com.cdac.rest.entities.AppointmentPatientAssociationEntity;
import com.cdac.rest.entities.AppointmentRequest;
import com.cdac.rest.entities.AppointmentTime;
import com.cdac.rest.entities.AppointmentTimeRequest;
import com.cdac.rest.entities.DoctorRegistrationEntity;
import com.cdac.rest.entities.PatientRegistrationEntity;
import com.cdac.rest.services.AppointmentService;
import com.cdac.rest.services.AppointmentTimeService;
import com.cdac.rest.services.DoctorRegistrationService;
import com.cdac.rest.services.PatientRegistrationService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	PatientRegistrationService patientservice;
	
	@Autowired
	AppointmentService appointmentService;
	
	@Autowired
	DoctorRegistrationService doctorService;
	
	@Autowired
	AppointmentTimeService appointmentTimeService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/bookSlot")
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentRequest appointment) {
    	Integer patientLoginId = appointment.getPatientId();
    	Integer doctorid = appointment.getDoctorId();
    	DoctorRegistrationEntity doctor = doctorService.getDoctorById(doctorid);
		PatientRegistrationEntity patient = patientservice.getPatientByLoginId(patientLoginId);
		List<AppointmentTime> appointmentTimes = appointmentTimeService.getAppointmentTimesByDoctorSlotAndDate(doctor.getDoctorid(), appointment.getAppointmentTime(), appointment.getAppointmentDate());
        appointmentTimes.forEach(appointmentTime -> appointmentTime.setFlag(0));
        appointmentTimeService.saveAllAppointmentTimes(appointmentTimes);
        Appointment ap = new Appointment(patient, doctor, appointment.getAppointmentDate(), appointment.getAppointmentTime(), appointment.getNotes());
        Appointment savedAppointment = appointmentService.saveAppointment(ap);

        return new ResponseEntity<>(savedAppointment, HttpStatus.OK);
    }
    
    @GetMapping("/getAppointments/{doctorId}/{appointmentDate}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDateAndDoctorId(
    		@PathVariable("doctorId") Integer doctorId,
    		@PathVariable("appointmentDate") String appointmentDate) {
    	
        DoctorRegistrationEntity doctor = doctorService.findDoctorById(doctorId);
      //   doctorId= doctor.getDoctorid();
        List<Appointment> appointments = appointmentService.getAppointmentsByDoctorIdAndDate(doctor, appointmentDate);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
    
    @GetMapping("/getAppointments/{patientLoginid}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientLoginId(
    		@PathVariable("patientLoginid") Integer patientloginId) {
    	
      //  DoctorRegistrationEntity doctor = doctorService.findDoctorById(doctorId);
      //   doctorId= doctor.getDoctorid();
    	PatientRegistrationEntity p = patientservice.getPatientByLoginId(patientloginId);
        List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(p);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
    
    @PutMapping("/updatetstatus/{appointmentId}")
    public ResponseEntity<String> updateAppointmentStatus(
            @PathVariable("appointmentId") Integer appointmentId,
            @RequestBody String status) {
        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        if (appointment == null) {
            return new ResponseEntity<>("Appointment not found", HttpStatus.NOT_FOUND);
        }
        appointment.setStatus(status);
        appointmentService.saveUpdateAppointment(appointment);
        return new ResponseEntity<>("Appointment status updated successfully", HttpStatus.OK);
    }
    
    @GetMapping("/getall")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }
    
    @GetMapping("/getDoctorAppointments/{DoctorLoginId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorLoginId(
    		@PathVariable("DoctorLoginId") Integer doctorLoginId) {

    	DoctorRegistrationEntity d = doctorService.findDoctorById(doctorLoginId);
        List<Appointment> appointments = appointmentService.getAppointmentsByDoctorLoginId(d);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    
}
