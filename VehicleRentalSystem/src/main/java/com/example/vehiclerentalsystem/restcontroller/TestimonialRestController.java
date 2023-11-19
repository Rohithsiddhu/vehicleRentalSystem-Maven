package com.example.vehiclerentalsystem.restcontroller;

import java.util.List;

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
	
	@Autowired
	ITestimonialService service;
	
	@PostMapping("/add")
	public TestimonialDTO addTestimonial(TestimonialDTO testimonialDto) {
		return service.addTestimonial(testimonialDto);
		
	}
	@PutMapping("/update")
	public TestimonialDTO updateTestimonial(TestimonialDTO testimonialDto) {
		return service.updateTestimonial(testimonialDto);
	}
	@GetMapping("/get/{id}")
	public TestimonialDTO findById(@PathVariable Long id) throws Exception{
		return service.findById(id);
	}
	@GetMapping("/getall")
	public List<TestimonialDTO> findAll(){
		return service.getAll();
	}
	@DeleteMapping("/delete")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}

}
