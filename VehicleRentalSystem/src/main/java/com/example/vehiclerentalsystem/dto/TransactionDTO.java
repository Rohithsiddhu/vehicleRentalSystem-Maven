package com.example.vehiclerentalsystem.dto;

public class TransactionDTO {

	private long transactionId;
	private String transactonType;
	private double amount;

	private BookingDTO booking;
	
	public TransactionDTO() {
		super();
	}
	public TransactionDTO(long transactionId, String transactonType, double amount) {
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
	public BookingDTO getBooking() {
		return booking;
	}
	public void setBooking(BookingDTO booking) {
		this.booking = booking;
	}
	
	

}
