package com.cdac.rest.entities;

import java.util.List;

public class UserInfoResponse {

	int id;
	String username;
	List<String> roles;
	String accessToken;
	boolean isapproved;
	public UserInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfoResponse(int id, String username, List<String> roles, String accessToken) {
		super();
		this.id = id;
		this.username = username;
		this.roles = roles;
		this.accessToken = accessToken;
	}
	
	public UserInfoResponse(int id, String username, List<String> roles, String accessToken, boolean isapproved) {
		super();
		this.id = id;
		this.username = username;
		this.roles = roles;
		this.accessToken = accessToken;
		this.isapproved = isapproved;
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
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public boolean getIsapproved() {
		return isapproved;
	}
	public void setIsapproved(boolean isapproved) {
		this.isapproved = isapproved;
	}
	
	
}