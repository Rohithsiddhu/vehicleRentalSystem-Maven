package com.example.vehiclerentalsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	
	private String modelName;
	private int capacity;
	private String type;
	@Positive
	private float costPerDay;
	@Positive
	private float mileage;
	private String registrationNumber;
	
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(long id, String modelName, int capacity, String type, float costPerDay, float mileage,
			String registrationNumber) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.capacity = capacity;
		this.type = type;
		this.costPerDay = costPerDay;
		this.mileage = mileage;
		this.registrationNumber = registrationNumber;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getCostPerDay() {
		return costPerDay;
	}
	public void setCostPerDay(float costPerDay) {
		this.costPerDay = costPerDay;
	}
	public float getMileage() {
		return mileage;
	}
	public void setMileage(float mileage) {
		this.mileage = mileage;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	
	

}
