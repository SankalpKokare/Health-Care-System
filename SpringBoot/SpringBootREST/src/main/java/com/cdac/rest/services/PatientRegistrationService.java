package com.cdac.rest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdac.rest.entities.PatientRegistrationEntity;
import com.cdac.rest.repositories.PatientRegistrationRepository;

@Service
public class PatientRegistrationService {
	@Autowired
	PatientRegistrationRepository prrepo;

	public List<PatientRegistrationEntity> getAllPatient() {
		return prrepo.findAll();
	}

	public PatientRegistrationEntity savePatient(PatientRegistrationEntity pre) {
		return prrepo.save(pre);
	}

	public PatientRegistrationEntity getPatientByLoginId(int patientLoginId) {
		return prrepo.findPatientById(patientLoginId);
	}

	public int registerPatient(String firstname, String lastname, String paddress, long pphoneno, String pgender,
			String pemail, String pcity, String pstate, long ppincode, int patientLoginId) {
		return prrepo.updatePatient(firstname, lastname, paddress, pphoneno, pgender, pemail, pcity, pstate, ppincode,
				patientLoginId);
	}
	public void deletePatientById(int patient_id) {
		prrepo.deleteById(patient_id);
	}
}
