package com.example.vehiclerentalsystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalsystem.dto.BookingDTO;
import com.example.vehiclerentalsystem.entity.Booking;
import com.example.vehiclerentalsystem.entity.User;
import com.example.vehiclerentalsystem.entity.Vehicle;
import com.example.vehiclerentalsystem.repository.BookingRepository;
import com.example.vehiclerentalsystem.repository.UserRepository;
import com.example.vehiclerentalsystem.repository.VehicleRepository;
import com.example.vehiclerentalsystem.service.IBookingService;
@Service
public class BookingServiceImpl implements IBookingService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Autowired
	BookingRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	

	@Override
	public BookingDTO addBooking(BookingDTO bookingDto) {
		// Check if user exists by userId
		// Check if vehicle is available vehicleId
		logger.info("Getting user details"+ bookingDto.getUserId());
		Optional<User> optionalUser =userRepository.findById(bookingDto.getUserId());
		if(optionalUser.isEmpty()) {
			throw new RuntimeException("User doesnot exist");			 
		}
		logger.info("Getting vehicle details: "+ bookingDto.getVehicleId());
		Optional<Vehicle> optionalVehicle = vehicleRepository.findById(bookingDto.getVehicleId());
		if(optionalVehicle.isEmpty()) {
			throw new RuntimeException("Vehicle doesnot exist");
		}
		Booking booking = new Booking();
		booking.setUser(optionalUser.get());
		booking.setVehicle(optionalVehicle.get());
		booking.setFromDate(bookingDto.getFromDate());
		booking.setToDate(bookingDto.getToDate());
		BeanUtils.copyProperties(bookingDto, booking);
		booking =  repository.save(booking);
		return bookingDto;
		
		
	}

	@Override
	public BookingDTO updateBooking(BookingDTO bookingDto) {

		Booking booking = new Booking();
		BeanUtils.copyProperties(bookingDto, booking);
		booking =  repository.save(booking);
		BeanUtils.copyProperties(booking,bookingDto);
		return bookingDto;
	}

	@Override
	public BookingDTO findById(Long id)throws Exception {
		Booking booking = new Booking();
		BookingDTO bookingDTO = new BookingDTO();
		booking =  repository.findById(id).orElseThrow(() -> new Exception("Booking  not found - " + id));
		BeanUtils.copyProperties(booking,bookingDTO);
		return bookingDTO;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

	@Override
	public List<Booking> findAll() {
		 List<Booking> bookingList = repository.findAll();
		 logger.info("the size of get all bookings: "+bookingList.size());
		 return bookingList;
		
	}

}
