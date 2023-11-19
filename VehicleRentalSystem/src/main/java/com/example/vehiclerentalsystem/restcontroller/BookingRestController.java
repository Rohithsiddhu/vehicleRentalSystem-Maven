package com.example.vehiclerentalsystem.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	IBookingService service;
	
	
	public BookingRestController(IBookingService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/add")
	public BookingDTO addBooking(@RequestBody BookingDTO booking) {
		return service.addBooking(booking);
	}

	  @PutMapping("/put/{id}")
	  public BookingDTO updateBooking(@PathVariable Long id,@RequestBody BookingDTO booking) {
		  return service.updateBooking(booking);
	  }
	  @GetMapping("/get/{id}")
	  public BookingDTO getBooking(@PathVariable Long id) throws Exception {
		  return service.findById(id);
	  }
	  @DeleteMapping("/delete/{id}")
	  public void deleteById(@PathVariable Long id) {
		  service.deleteById(id);
		  
	  }
	  @GetMapping("/getall")
	  public List<Booking> findAll(){
		  return service.findAll();
	  }
}
