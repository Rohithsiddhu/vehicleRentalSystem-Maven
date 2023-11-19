package com.example.vehiclerentalsystem.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public TestimonialDTO addTestimonial(TestimonialDTO testimonialDto) {
		logger.info("Testimonial added successfully");
		return service.addTestimonial(testimonialDto);
		
	}
	@PutMapping("/update")
	public TestimonialDTO updateTestimonial(TestimonialDTO testimonialDto) {
		logger.info("Testimonial updated successfully");
		return service.updateTestimonial(testimonialDto);
	}
	@GetMapping("/get/{id}")
	public TestimonialDTO findById(@PathVariable Long id) throws Exception{
		logger.info("Testimonial found with this ");
		return service.findById(id);
	}
	@GetMapping("/getall")
	public List<TestimonialDTO> findAll(){
		logger.info("Testimonials List");
		return service.getAll();
	}
	@DeleteMapping("/delete")
	public void deleteById(@PathVariable Long id) {
		logger.info("Testimonial deleted successfully");
		service.deleteById(id);
	}

}
