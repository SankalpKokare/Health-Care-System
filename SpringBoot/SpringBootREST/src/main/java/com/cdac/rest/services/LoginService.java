package com.cdac.rest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.rest.entities.LoginEntity;
import com.cdac.rest.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepo;
	
	public LoginEntity getLoginDetails(String username , String password) {
		
		LoginEntity loginObject;
		Optional<LoginEntity> log = loginRepo.getLoginDetails(username, password);
		try {
			loginObject = log.get();
		}catch (Exception e) {
			loginObject = null;
		}
		return loginObject;
	}
	
	public LoginEntity save(LoginEntity le)
	{
		return loginRepo.save(le);
	}
	
	public void getLoginById(int loginID) {
		
		 loginRepo.findById(loginID);
		
	}

	public void approveLogin(int loginID) {
			
		LoginEntity loginObject;
		loginObject = loginRepo.findById(loginID).get();
		loginObject.setId_approved(true);
		loginRepo.save(loginObject);
	}
	
	public void disapproveLogin(int loginID) {
		
		LoginEntity loginObject;
		loginObject = loginRepo.findById(loginID).get();
		loginObject.setId_approved(false);
		loginRepo.save(loginObject);
		
	}
	
}
