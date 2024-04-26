package com.cdac.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.rest.entities.Specialization;
import com.cdac.rest.services.SpeacilizationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SpecializationController {
	@Autowired
	SpeacilizationService spcon;

	@GetMapping("/getAllSpecialization")
	public List<Specialization> getAll()
	{
		return spcon.getAll();
	}

}
