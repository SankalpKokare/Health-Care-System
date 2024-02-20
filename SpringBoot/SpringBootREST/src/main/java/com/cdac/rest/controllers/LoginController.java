
package com.cdac.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.rest.entities.LoginData;
import com.cdac.rest.entities.LoginEntity;
import com.cdac.rest.services.LoginService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/verifyLogin")
	public LoginEntity  verifyLogin ( @RequestBody LoginData loginData) {
		
			return loginService.getLoginDetails(loginData.getUsername(), loginData.getPassword());
		
	}
	
	@GetMapping("/approve/{loginID}")
    public ResponseEntity<Void> approveLogin(@PathVariable("loginID") int loginID) {
		loginService.approveLogin(loginID);
        return ResponseEntity.ok().build();
    }
	
	@GetMapping("/disapprove/{loginID}")
    public ResponseEntity<Void> disapproveLogin(@PathVariable("loginID") int loginID) {
		loginService.disapproveLogin(loginID);
        return ResponseEntity.ok().build();
    }
}
