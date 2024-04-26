package com.cdac.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.rest.entities.RoleEntity;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Integer> {

}
