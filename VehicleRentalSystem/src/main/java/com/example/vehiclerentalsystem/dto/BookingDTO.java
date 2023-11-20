package com.example.vehiclerentalsystem.dto;

import java.sql.Date;


public class BookingDTO {

	private long id;
	private Date fromDate;
	private Date toDate;
	private Long userId;
	private Long vehicleId;
	
	public BookingDTO() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setBookingId(long id) {
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	
	

}
