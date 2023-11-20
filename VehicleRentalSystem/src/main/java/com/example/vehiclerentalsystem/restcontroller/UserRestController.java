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

import com.example.vehiclerentalsystem.dto.UserDTO;
import com.example.vehiclerentalsystem.entity.User;
import com.example.vehiclerentalsystem.service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	
	@Autowired
	IUserService service;
	
	
	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public UserDTO addUser(@RequestBody UserDTO user) {
		logger.info("User added successfully");
		return service.addUser(user);
		
	}
	
	@GetMapping("/get/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public UserDTO findById(@PathVariable Long id) throws Exception{
		logger.info("User found with this id");
		return service.findById(id);
	}
	@PutMapping("/put/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public UserDTO updateUser(@PathVariable Long id,@RequestBody UserDTO user) {
		logger.info("User updated successfully");
		return service.updateUser(user);
	}
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		logger.info("User deleted successfully");
		 service.deleteById(id);
	}
	
	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public List<User> findAll(){
		logger.info("User list ");
		return service.findAll();
	}
}
