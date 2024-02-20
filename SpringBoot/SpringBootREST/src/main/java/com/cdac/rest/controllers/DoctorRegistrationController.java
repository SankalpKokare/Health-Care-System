package com.cdac.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.rest.entities.DoctorRegistrationEntity;
import com.cdac.rest.entities.DummyDoctorRegistrationEntity;
import com.cdac.rest.entities.LoginEntity;
import com.cdac.rest.entities.RoleEntity;
import com.cdac.rest.services.DoctorRegistrationService;
import com.cdac.rest.services.LoginService;
import com.cdac.rest.services.RoleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DoctorRegistrationController {
	@Autowired
	DoctorRegistrationService doctorService;
	@Autowired
	LoginService loginService;
	@Autowired
	RoleService roleService;

	// http://localhost:8080/getAllDoctor
	@GetMapping("/getAllDoctor")
	public List<DoctorRegistrationEntity> getAllDoctor() {
		return doctorService.getAllDoctor();
	}

	@PostMapping("/saveDoctor")
	public DoctorRegistrationEntity saveDoctor(@RequestBody DoctorRegistrationEntity dre) {
		return doctorService.saveDoctor(dre);
	}
	
	// http://localhost:8080/registerDoctor
	// first_name,last_name,address,city,state,pincode,phonenumber,email,gender,description,image,specialization,education,username,password,rolename,id_approved
	@PostMapping("/registerDoctor")
	public DoctorRegistrationEntity regsiterDoctor(@RequestBody DummyDoctorRegistrationEntity ddr) {
		RoleEntity r = roleService.getRole(2);
		LoginEntity le = new LoginEntity(ddr.getUsername(), ddr.getPassword(), r, true);
		loginService.save(le);
		DoctorRegistrationEntity d = new DoctorRegistrationEntity(ddr.getFirst_name(), ddr.getLast_name(),
				ddr.getAddress(), ddr.getCity(), ddr.getState(), ddr.getPincode(), ddr.getPhonenumber(), ddr.getEmail(),
				ddr.getGender(), ddr.getDescription(), ddr.getImage(), ddr.getSpecialization(), ddr.getEducation(), le);
		ddr.setDoctor_login_id(le.getLogin_id());
		return doctorService.saveDoctor(d);
	}

	
	// http://localhost:8080/deleteDoctor/39
	@DeleteMapping("/deleteDoctor/{doctor_id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable("doctor_id") int doctor_id) {
		doctorService.deleteDoctorById(doctor_id);
		return ResponseEntity.noContent().build();
	}

	// http://localhost:8080/getdoctorprofile/39
	@GetMapping("/getdoctorprofile/{doctorLoginId}")
	public ResponseEntity<DoctorRegistrationEntity> getDoctorByLoginId(@PathVariable int doctorLoginId) {
		DoctorRegistrationEntity doctor = doctorService.findDoctorById(doctorLoginId);
		if (doctor != null) {
			return ResponseEntity.ok(doctor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
//	@PutMapping("/doctorUpdate/{DoctorLoginId}")
//	public int update_Doctor(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
//			@RequestParam("paddress") String paddress, @RequestParam("pphoneno") long pphoneno,
//			@RequestParam("pgender") String pgender, @RequestParam("pemail") String pemail,
//			@RequestParam("pcity") String pcity, @RequestParam("pstate") String pstate,
//			@RequestParam("pdescription") String pdescription,@RequestParam("pimage") String pimage,
//			@RequestParam("pspecialization") String pspecialization,@RequestParam("peducation") String peducation,
//			@RequestParam("ppincode") long ppincode, @PathVariable("DoctorLoginId") int DoctorLoginId) {
//		return doctorService.registerDoctor(firstname, lastname, paddress, pphoneno, pgender, pemail, pcity, pstate, pdescription, pimage, pspecialization, peducation, ppincode, DoctorLoginId);
//}
//	@PutMapping("/approveDoctor")
//    public ResponseEntity<String> approveDoctor(@RequestBody LoginEntity doctorLoginId) {
//        int updatedRows = doctorService.approveDoctor(doctorLoginId);
//        if (updatedRows > 0) {
//            return ResponseEntity.ok("Doctor approved successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to approve doctor.");
//        }
//    }
}
