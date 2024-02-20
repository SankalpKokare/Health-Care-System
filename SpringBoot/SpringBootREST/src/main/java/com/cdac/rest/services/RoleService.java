package com.cdac.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.rest.entities.RoleEntity;
import com.cdac.rest.repositories.RoleRepository;

@Service
public class RoleService 
{

		@Autowired
		RoleRepository roleRepo;
		public RoleEntity getRole(int id)
		{
			return roleRepo.findById(id).get();
		}
}
