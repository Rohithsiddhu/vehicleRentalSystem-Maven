package com.example.vehiclerentalsystem.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public ContactUsDTO addDetails(ContactUsDTO contactusDto) {
		logger.info("Added Contactus details");
		return service.addDetails(contactusDto);
	}
	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public ContactUsDTO updateDetails(ContactUsDTO contactusDto) {
		logger.info("Updated contactus details");
		return service.updateDetails(contactusDto);

}
	@GetMapping("/get/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public ContactUsDTO findById(@PathVariable Long id) throws Exception {
		logger.info("Contactus details found");
		return service.findById(id);
	}
	@DeleteMapping("/delete")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public void deleteById(@PathVariable Long id) {
		logger.info("Contactus details deleted successfully");
		service.deleteById(id);
	}
}
