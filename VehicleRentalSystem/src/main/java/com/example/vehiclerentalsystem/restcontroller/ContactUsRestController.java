package com.example.vehiclerentalsystem.restcontroller;

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

import com.example.vehiclerentalsystem.dto.ContactUsDTO;
import com.example.vehiclerentalsystem.service.IContactUsService;

@RestController
@RequestMapping("/api/contactus")
public class ContactUsRestController {
	Logger logger=LoggerFactory.getLogger(ContactUsRestController.class);
	
	@Autowired
	IContactUsService service;
	
	
	public ContactUsRestController(IContactUsService service) {
		super();
		this.service = service;
	}
	@PostMapping("/add")
	public ContactUsDTO addDetails(ContactUsDTO contactusDto) {
		logger.info("Added Contactus details");
		return service.addDetails(contactusDto);
	}
	@PutMapping("/update")
	public ContactUsDTO updateDetails(ContactUsDTO contactusDto) {
		logger.info("Updated contactus details");
		return service.updateDetails(contactusDto);

}
	@GetMapping("/get/{id}")
	public ContactUsDTO findById(@PathVariable Long id) throws Exception {
		logger.info("Contactus details found");
		return service.findById(id);
	}
	@DeleteMapping("/delete")
	public void deleteById(@PathVariable Long id) {
		logger.info("Contactus details deleted successfully");
		service.deleteById(id);
	}
}
