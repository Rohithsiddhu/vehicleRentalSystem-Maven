package com.example.vehiclerentalsystem.service;

import java.util.List;

import com.example.vehiclerentalsystem.dto.BookingDTO;
import com.example.vehiclerentalsystem.entity.Booking;

public interface IBookingService {
	public BookingDTO addBooking(BookingDTO booking);
	public BookingDTO updateBooking(BookingDTO booking);
	public BookingDTO findById(Long id)throws Exception;
	public void deleteById(Long id);
	public List<Booking> findAll();
	

}
