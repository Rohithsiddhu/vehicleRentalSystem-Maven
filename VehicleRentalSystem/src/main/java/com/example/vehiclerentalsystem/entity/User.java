package com.example.vehiclerentalsystem.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	//@NotNull(message = "Email is mandatory")
	@Email
	private String email;
	
	@NotNull
	@Size(min = 4, max = 15)
	private String password;
	
	@NotNull(message = "Name is mandatory")
	private String name;
	
	@Size(min = 10, max = 10)
	private String contactNumber;
	
	@Size(min = 12, max = 12)
	private String aadhar;
	
	//@Pattern(regexp = "[A-Z] [0-9]")
	private String drivingLicence;
	
	@NotBlank
	private String address;
	
	private String roles;

    private boolean enabled;
	
	
	public User() {
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public User(long id, @Email String email, @NotNull @Size(min = 4, max = 15) String password,
			@NotNull(message = "Name is mandatory") String name, @Size(min = 10, max = 10) String contactNumber,
			@Size(min = 12, max = 12) String aadhar, String drivingLicence, @NotBlank String address, String roles,
			boolean enabled) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.contactNumber = contactNumber;
		this.aadhar = aadhar;
		this.drivingLicence = drivingLicence;
		this.address = address;
		this.roles = roles;
		this.enabled = enabled;
	}
	
	
	
	

}
