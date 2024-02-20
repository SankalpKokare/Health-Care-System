package com.cdac.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.rest.entities.DoctorRegistrationEntity;
import com.cdac.rest.entities.LoginEntity;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface DoctorRegistrationRepository extends JpaRepository<DoctorRegistrationEntity, Integer> {

	@Query("SELECT d FROM DoctorRegistrationEntity d WHERE d.doctor_login_id.login_id = :doctorLoginId")
	public DoctorRegistrationEntity findDoctorById(int doctorLoginId);

//	@Query("SELECT d FROM DoctorRegistrationEntity d WHERE d.city = :pcity")
//	public Optional<DoctorRegistrationEntity> findDoctorByCity(@Param("pcity") String pcity);

//	@Modifying
//	@Query("update DoctorRegistrationEntity p SET p.first_name = :firstname, p.last_name = :lastname, p.address = :paddress, p.phonenumber = :pphoneno, p.gender = :pgender, p.email = :pemail, p.city = :pcity, p.state = :pstate, p.description = :pdescription, p.image = :pimage, p.specialization = :pspecialization, p.education = :peducation, p.pincode = :ppincode WHERE p.doctor_login_id.login_id = :doctorLoginId")
//	public int updateDoctor(@Param("firstname") String firstname, @Param("lastname") String lastname,
//	        @Param("paddress") String paddress, @Param("pphoneno") long pphoneno,
//	        @Param("pgender") String pgender, @Param("pemail") String pemail,
//	        @Param("pcity") String pcity, @Param("pstate") String pstate,
//	        @Param("pdescription") String pdescription, @Param("pimage") String pimage,
//	        @Param("pspecialization") String pspecialization, @Param("peducation") String peducation,
//	        @Param("ppincode") long ppincode, @Param("doctorLoginId") int doctorLoginId);
//	@Modifying
//    @Transactional
//    @Query("UPDATE DoctorRegistrationEntity d SET d.doctor_login_id.is_approved = :isApproved " +
//           "WHERE d.doctor_login_id = :doctorLoginId")
//    int updateApprovalStatus(@Param("isApproved") boolean isApproved, @Param("doctorLoginId") LoginEntity doctorLoginId);
}

