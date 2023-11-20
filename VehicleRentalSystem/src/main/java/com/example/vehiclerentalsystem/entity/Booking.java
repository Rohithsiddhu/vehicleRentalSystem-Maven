package com.example.vehiclerentalsystem.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Table(name="booking")
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
    @JsonFormat(pattern="yyyy-MM-dd ")
	private Date fromDate;
	@JsonFormat(pattern="yyyy-MM-dd ")
	private Date toDate;
	

	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	@ManyToOne
    @JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	public Booking() {
		super();
	}
	public Booking(long id,Date fromDate, Date toDate) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public long getId() {
		return id;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	

}
