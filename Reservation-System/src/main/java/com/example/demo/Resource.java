package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	public Resource(Long id,String name) {
		this.id=id;
		this.name=name;
	}
	public Resource() {
		
	}
	
	//Getter
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	//Setter
	public void setId(Long id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
}
