package com.example.vehiclerentalsystem.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
		logger.info("Booking added successfully");
		return service.addBooking(booking);
	}

	  @PutMapping("/put/{id}")
	  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	  public BookingDTO updateBooking(@PathVariable Long id,@RequestBody BookingDTO booking) {
		  logger.info("Booking updated successfully ");
		  return service.updateBooking(booking);
	  }
	  @GetMapping("/get/{id}")
	  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	  public BookingDTO getBooking(@PathVariable Long id) throws Exception {
		  logger.info("Booking found");
		  return service.findById(id);
	  }
	  @DeleteMapping("/delete/{id}")
	  @PreAuthorize("hasAnyAuthority('ROLE_USER')")
	  public void deleteById(@PathVariable Long id) {
		  logger.info("Booking deleted successfully");
		  service.deleteById(id);
		  
	  }
	  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	  @GetMapping("/getall")
	  public List<Booking> findAll(){
		  logger.info("Booking List");
		  return service.findAll();
	  }
}
