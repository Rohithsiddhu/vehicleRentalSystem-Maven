package com.example.vehiclerentalsystem.dto;

import java.util.Set;

import com.example.vehiclerentalsystem.entity.Role;

public class UserDTO {

	private long id;
	private String email;
	private  String password;
	private String name;
	private String contactNumber;
	private String aadhar;
	private String drivingLicence;
	private String address;
	 private String roles ;
	
	public UserDTO() {
		super();
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getDrivingLicence() {
		return drivingLicence;
	}
	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}



	public String getRoles() {
		return roles;
	}



	public void setRoles(String roles) {
		this.roles = roles;
	}

	
	
	

}
