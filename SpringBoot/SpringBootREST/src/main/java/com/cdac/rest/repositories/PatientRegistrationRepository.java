package com.cdac.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cdac.rest.entities.PatientRegistrationEntity;

import jakarta.transaction.Transactional;

@Repository
@Transactional

public interface PatientRegistrationRepository extends JpaRepository<PatientRegistrationEntity, Integer> {

	@Query("SELECT d FROM PatientRegistrationEntity d WHERE d.patient_login_id.login_id = :patientLoginId ")
	public PatientRegistrationEntity findPatientById(int patientLoginId);

//	@Query("SELECT d FROM PatientRegistrationEntity d WHERE d.city = :pcity")
//	public Optional<PatientRegistrationEntity> findPatientByCity(@Param("pcity") String pcity);

	@Modifying
	@Query("update PatientRegistrationEntity p SET p.first_name= :firstname, p.last_name= :lastname, p.address= :paddress, p.phone_number= :pphoneno, p.gender= :pgender, p.email_id= :pemail, p.city= :pcity, p.state= :pstate, p.pincode= :ppincode WHERE p.patient_login_id.login_id= :patientLoginId")
	public int updatePatient(@Param("firstname") String firstname, @Param("lastname") String lastname,
			@Param("paddress") String paddress, @Param("pphoneno") long pphoneno, @Param("pgender") String pgender,
			@Param("pemail") String pemail, @Param("pcity") String pcity, @Param("pstate") String pstate,
			@Param("ppincode") long ppincode, @Param("patientLoginId") int patientLoginId);
}
