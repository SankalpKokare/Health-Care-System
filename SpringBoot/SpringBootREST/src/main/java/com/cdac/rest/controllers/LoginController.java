//package com.cdac.rest.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cdac.rest.entities.LoginData;
//import com.cdac.rest.entities.LoginEntity;
//import com.cdac.rest.services.LoginService;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//public class LoginController {
//
//	@Autowired
//	LoginService loginService;
//	
//	@PostMapping("/verifyLogin")
//	public LoginEntity  verifyLogin ( @RequestBody LoginData loginData) {
//		
//			return loginService.getLoginDetails(loginData.getUsername(), loginData.getPassword());
//		
//	}
//}
