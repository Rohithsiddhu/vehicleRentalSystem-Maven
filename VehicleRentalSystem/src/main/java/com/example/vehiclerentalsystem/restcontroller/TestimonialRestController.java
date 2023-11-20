package com.example.vehiclerentalsystem.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclerentalsystem.dto.TestimonialDTO;
import com.example.vehiclerentalsystem.service.ITestimonialService;

@RestController
@RequestMapping("/api/testimonial")
public class TestimonialRestController {
	Logger logger = LoggerFactory.getLogger(TestimonialRestController.class);
	
	@Autowired
	ITestimonialService service;
	
	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public TestimonialDTO addTestimonial(TestimonialDTO testimonialDto) {
		  logger.info("Received request to add testimonial: {}", testimonialDto.getTestimonialsid());
		return service.addTestimonial(testimonialDto);
		
	}
	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public TestimonialDTO updateTestimonial(TestimonialDTO testimonialDto) {
		  logger.info("Received request to update Testimonial for Testimonial Id: {}", testimonialDto.getTestimonialsid());
		return service.updateTestimonial(testimonialDto);
	}
	@GetMapping("/get/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public TestimonialDTO findById(@PathVariable Long id) throws Exception{
		logger.info("Testimonial found with this ");
		return service.findById(id);
	}
	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public List<TestimonialDTO> findAll(){
		logger.info("Testimonials List");
		return service.getAll();
	}
	@DeleteMapping("/delete")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		  logger.info("Received request to delete testimonial with Id: {}", id);
		  service.deleteById(id);
		  return new ResponseEntity<>("Testimonial deleted sucessfully", HttpStatus.ACCEPTED);
	}

}
