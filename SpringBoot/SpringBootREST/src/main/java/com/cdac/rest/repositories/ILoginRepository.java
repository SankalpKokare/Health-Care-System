package com.cdac.rest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cdac.rest.entities.LoginEntity;

@Repository
public interface ILoginRepository extends JpaRepository<LoginEntity, Integer> {

		@Query("Select l from LoginEntity l where username=:uid and password = :pwd ")
		public  Optional<LoginEntity> getLoginDetails(String uid , String pwd);
}
