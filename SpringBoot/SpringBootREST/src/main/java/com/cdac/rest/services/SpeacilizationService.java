package com.cdac.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.rest.entities.Specialization;
import com.cdac.rest.repositories.SpecializationRepository;

@Service
public class SpeacilizationService 
{
	@Autowired
	SpecializationRepository sprepo;
	public List<Specialization> getAll()
	{
		return sprepo.findAll();
	}

}
