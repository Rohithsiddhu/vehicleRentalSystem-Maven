package com.example.vehiclerentalsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class ContactUs {
	@Id
	private long id;
	private String email;
	private String phoneNumber;
	
	public ContactUs() {
		super();
	}
	public ContactUs(long id, String email, String phoneNumber) {
		super();
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
