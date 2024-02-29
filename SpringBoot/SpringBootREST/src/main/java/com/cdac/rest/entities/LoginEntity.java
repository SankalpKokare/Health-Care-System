package com.cdac.rest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="login_table")
public class LoginEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int login_id;
	@Column
	String username;
	@Column
	String password;
	@ManyToOne
	@JoinColumn(name = "role_id")
	RoleEntity role_id;
	@Column
	boolean is_approved;
	
	public LoginEntity() {
		super();
	}
	
	public LoginEntity(String username, String password, RoleEntity role_id, boolean is_approved) {
		super();
		this.username = username;
		this.password = password;
		this.role_id = role_id;
		this.is_approved = is_approved;
	}

	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RoleEntity getRole_id() {
		return role_id;
	}
	public void setRole_id(RoleEntity role_id) {
		this.role_id = role_id;
	}
	public boolean isId_approved() {
		return is_approved;
	}
	public void setId_approved(boolean id_approved) {
		this.is_approved = id_approved;
	}
	
	
	
	
	
}
