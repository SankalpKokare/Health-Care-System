package com.cdac.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.rest.entities.Specialization;
@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {

}
