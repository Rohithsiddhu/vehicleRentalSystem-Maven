package com.example.vehiclerentalsystem.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclerentalsystem.dto.BookingDTO;
import com.example.vehiclerentalsystem.entity.Booking;
import com.example.vehiclerentalsystem.exceptions.BookingNotFoundException;
import com.example.vehiclerentalsystem.service.IBookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingRestController {
	
	Logger logger =LoggerFactory.getLogger(BookingRestController.class);
	
	@Autowired
	IBookingService service;
	
	
	public BookingRestController(IBookingService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public BookingDTO addBooking(@RequestBody BookingDTO booking) {
		 logger.info("Received request to add booking: {}",booking.getId());
		return service.addBooking(booking);
	}

	  @PutMapping("/put/{id}")
	  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	  public BookingDTO updateBooking(@PathVariable Long id,@RequestBody BookingDTO booking) {
		   logger.info("Received request to update Booking for Booking Id: {}", booking.getId());
		  return service.updateBooking(booking);
	  }
	  @GetMapping("/get/{id}")
	  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	  public BookingDTO getBooking(@PathVariable Long id) throws Exception {
		  logger.info("Received request to get booking profile for id: {}", id);

		   BookingDTO booking= service.findById(id);
		   if(booking.getId()!= id) {
		             logger.info("Booking not found for id: {}", id);
		             
		              throw new BookingNotFoundException(HttpStatus.NOT_FOUND,"booking with id:"+id+" notfound");
		   }
		    return service.findById(id);
	  }
	  @DeleteMapping("/delete/{id}")
	  @PreAuthorize("hasAnyAuthority('ROLE_USER')")
	  public void deleteById(@PathVariable Long id) {
		  logger.info("Received request to delete booking with bookingId: {}", id);
		  service.deleteById(id);
		  
	  }
	  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	  @GetMapping("/getall")
	  public List<Booking> findAll(){
		  logger.info("Received request to get all bookings");
	         List<Booking> booking= service.findAll();
	   if(booking.isEmpty()) {
	             logger.info("Zero bookings found");
	             // Throw an AdminNotFoundException if no admins are found

	    throw new BookingNotFoundException(HttpStatus.NO_CONTENT,"Zero Bookings"); 
	   }
	   return booking;
	  }
}
