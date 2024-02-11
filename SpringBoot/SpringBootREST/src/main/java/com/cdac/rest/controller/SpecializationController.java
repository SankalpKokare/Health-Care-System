package com.cdac.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.rest.entities.Specialization;
import com.cdac.rest.services.SpeacilizationService;

@RestController
public class SpecializationController {
	@Autowired
	SpeacilizationService spcon;
	@GetMapping("/getall")
	public List<Specialization> getAll()
	{
		return spcon.getAll();
	}

}
