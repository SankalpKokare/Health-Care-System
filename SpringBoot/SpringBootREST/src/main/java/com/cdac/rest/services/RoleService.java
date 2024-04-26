package com.cdac.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.rest.entities.RoleEntity;
import com.cdac.rest.repositories.IRoleRepository;

@Service
public class RoleService 
{

		@Autowired
		IRoleRepository roleRepo;
		public RoleEntity getRole(int id)
		{
			return roleRepo.findById(id).get();
		}
}
