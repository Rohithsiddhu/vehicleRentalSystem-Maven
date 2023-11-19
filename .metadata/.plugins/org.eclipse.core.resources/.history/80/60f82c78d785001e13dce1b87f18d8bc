package com.example.vehiclerentalsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transactionId;
	private String transactonType;
	private double amount;
	@OneToOne
	@JoinColumn(name="bookingId", referencedColumnName = "userid")
	private Booking booking;
	
	public Transaction() {
		super();
	}
	public Transaction(long transactionId, String transactonType, double amount) {
		super();
		this.transactionId = transactionId;
		this.transactonType = transactonType;
		this.amount = amount;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactonType() {
		return transactonType;
	}
	public void setTransactonType(String transactonType) {
		this.transactonType = transactonType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	

}
