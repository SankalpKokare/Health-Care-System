package com.cdac.rest.entities;

import java.util.List;

public class UserInfoResponse {

	int id;
	String username;
	List<String> roles;
	public UserInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfoResponse(int id, String username, List<String> roles) {
		super();
		this.id = id;
		this.username = username;
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
}
