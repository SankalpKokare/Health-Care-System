package com.cdac.rest.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.ParamsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;
import org.springframework.web.servlet.support.RequestContext;

import com.cdac.rest.entities.LoginEntity;
import com.cdac.rest.repositories.LoginRepository;
import com.cdac.rest.repositories.LoginRepository;

import ch.qos.logback.core.net.LoginAuthenticator;


public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
	LoginRepository urepo;
    
    @Autowired
    PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//System.out.println("in load user");
		//String pwd = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getParameter("password");
		//System.out.println(pwd);
		//String enc_pwd = passwordEncoder.encode(pwd);
		//System.out.println(enc_pwd);
		LoginEntity u = urepo.getUser(username);
		if(u == null)
			throw new UsernameNotFoundException("Could not find user");
				
		return MyUserDetails.build(u);
	}

}
