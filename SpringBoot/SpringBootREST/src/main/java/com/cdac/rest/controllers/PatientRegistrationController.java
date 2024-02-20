package com.cdac.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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

import com.cdac.rest.entities.DummyPatientRegistrationEntity;
import com.cdac.rest.entities.LoginEntity;
import com.cdac.rest.entities.PatientRegistrationEntity;
import com.cdac.rest.entities.RoleEntity;
import com.cdac.rest.services.LoginService;
import com.cdac.rest.services.PatientRegistrationService;
import com.cdac.rest.services.RoleService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PatientRegistrationController {
	@Autowired
	PatientRegistrationService patientservice;
	@Autowired
	RoleService roleService;
	@Autowired
	LoginService loginservice;

	@GetMapping("/getAllPatient")
	public List<PatientRegistrationEntity> getAll() {
		return patientservice.getAllPatient();
	}

	@PostMapping("/registerPatient")
	public PatientRegistrationEntity registerPatient(@RequestBody DummyPatientRegistrationEntity pre) {
		RoleEntity r = roleService.getRole(3);
		LoginEntity l = new LoginEntity(pre.getUsername(), pre.getPassword(), r, true);
		loginservice.save(l);
		PatientRegistrationEntity p = new PatientRegistrationEntity(pre.getFirst_name(), pre.getLast_name(),
				pre.getaddress(), pre.getPhone_number(), pre.getGender(), pre.getEmail_id(), pre.getCity(),
				pre.getState(), pre.getPincode(), l);
		pre.setPatient_login_id(l.getLogin_id());
		return patientservice.savePatient(p);
	}
	
	@DeleteMapping("/deletePatient/{patient_id}")
	public ResponseEntity<Void> deletePatient(@PathVariable("patient_id") int patient_id) {
		patientservice.deletePatientById(patient_id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/getpatientprofile/{patientLoginId}")
	public ResponseEntity<PatientRegistrationEntity> getPatientByLoginId(@PathVariable int patientLoginId) {
		PatientRegistrationEntity patient = patientservice.getPatientByLoginId(patientLoginId);
		if (patient != null) {
			return ResponseEntity.ok(patient);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/patientupdate/{patientLoginId}")
	public int update_Patient(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("paddress") String paddress, @RequestParam("pphoneno") long pphoneno,
			@RequestParam("pgender") String pgender, @RequestParam("pemail") String pemail,
			@RequestParam("pcity") String pcity, @RequestParam("pstate") String pstate,
			@RequestParam("ppincode") long ppincode, @PathVariable("patientLoginId") int patientLoginId) {
		return patientservice.registerPatient(firstname, lastname, paddress, pphoneno, pgender, pemail, pcity, pstate,
				ppincode, patientLoginId);
	}

	

}
