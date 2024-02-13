package com.cdac.rest.controllers;

import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.rest.repositories.LoginRepository;
import com.cdac.rest.entities.LoginRequest;
import com.cdac.rest.entities.MessageResponse;
//import com.example.demo.entities.SignupRequest;
import com.cdac.rest.entities.LoginEntity;
import com.cdac.rest.entities.UserInfoResponse;
import com.cdac.rest.security.JwtUtils;
import com.cdac.rest.security.MyUserDetails;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class AuthController {
	
	  @Autowired
	  AuthenticationManager authManager;
	  
	  //@Autowired
	  //AuthenticationProvider authenticationProvider;

	  @Autowired
	  LoginRepository userRepository;	 

	  @Autowired
	  PasswordEncoder encoder;

	  @Autowired
	  JwtUtils jwtUtils;

	  @PostMapping("/verifyLogin")
	  public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {

		  System.out.print("In authController");
		  System.out.println(loginRequest.getUsername()+" : "+loginRequest.getPassword());
		  
		 //authenticationProvider.au
		  
	    Authentication authentication = authManager.
	        authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);

	    MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        System.out.println(userDetails);
	    
	    /*String jwtCookie = jwtUtils.generateTokenFromUsername(loginRequest.getUsername());
	    System.out.println(jwtCookie);*/
        ResponseCookie res_cookie = jwtUtils.generateJwtCookie(userDetails);
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    /*return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie)
	        .body(new UserInfoResponse(userDetails.getId(),
	                                   userDetails.getUsername(),	                                   
	                                   roles));*/
	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, res_cookie.toString())
		        .body(new UserInfoResponse(userDetails.getId(),
		                                   userDetails.getUsername(),	                                   
		                                   roles));
	  }
//
//	  @PostMapping("/signup")
//	  public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
//	    	   
//
//	    // Create new user's account
//	    User user = new User(signUpRequest.getUsername(),
//	                         encoder.encode(signUpRequest.getPassword()),"USER",true);

	   
	    /*if (strRoles == null) {
	      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	      roles.add(userRole);
	    } else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "admin":
	          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(adminRole);

	          break;
	        case "mod":
	          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(modRole);

	          break;
	        default:
	          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(userRole);
	        }
	      });
	    }

	    user.setRoles(roles); */
//	    userRepository.save(user);
//	    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//	  }
	  
	 @PostMapping("/signout")
	  public ResponseEntity<?> logoutUser() {
	    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
	        .body(new MessageResponse("You've been signed out!"));
	  }
}
