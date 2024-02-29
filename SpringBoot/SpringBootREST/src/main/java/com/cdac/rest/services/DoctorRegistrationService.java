package com.cdac.rest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.rest.entities.DoctorRegistrationEntity;
import com.cdac.rest.entities.LoginEntity;
import com.cdac.rest.repositories.DoctorRegistrationRepository;

import jakarta.transaction.Transactional;

@Service
public class DoctorRegistrationService {

	@Autowired
	DoctorRegistrationRepository doctorRepo;

	public List<DoctorRegistrationEntity> getAllDoctor() {
		return doctorRepo.findAll();
	}

	public DoctorRegistrationEntity saveDoctor(DoctorRegistrationEntity dre) {
		return doctorRepo.save(dre);
	}

	//login id 
	public DoctorRegistrationEntity findDoctorById(int doctorLoginId) {
		return doctorRepo.findDoctorById(doctorLoginId);
	}
	
	//primary key 
	 public DoctorRegistrationEntity getDoctorById(int doctorId) {
	        return doctorRepo.findById(doctorId).orElse(null);
	    }
	  

//	public int registerDoctor( String firstname, String lastname,
//			 String paddress,  long pphoneno,
//			 String pgender, String pemail,
//			 String pcity, String pstate,
//			String pdescription, String pimage,
//			  String pspecialization, String peducation,
//			  long ppincode, int DoctorLoginId) {
//		return doctorRepo.updateDoctor(firstname, lastname, paddress, pphoneno, pgender, pemail, pcity, pstate, pdescription, pimage, pspecialization, peducation, ppincode, DoctorLoginId);
//	}

	public void deleteDoctorById(int doctor_id) {
		doctorRepo.deleteById(doctor_id);
	}
//	 @Transactional
//	    public int approveDoctor(LoginEntity doctorLoginId) {
//	        return doctorRepo.updateApprovalStatus(true, doctorLoginId);
//	    }

}
