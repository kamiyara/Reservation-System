package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	@com.fasterxml.jackson.annotation.JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	public User(Long id,String username,String password) {
		this.id=id;
		this.username=username;
		this.password=password;
	}
	public User() {
	}
	
	//Getter
	public Long getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	//Setter
	public void setId(Long newId) {
		id=newId;
	}
	
	public void setUsername(String newUsername) {
		username=newUsername;
	}
	
	public void setPassword(String newPassword) {
		password=newPassword;
	}

}
