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

import com.example.vehiclerentalsystem.dto.UserDTO;
import com.example.vehiclerentalsystem.entity.User;
import com.example.vehiclerentalsystem.exceptions.UserNotFoundException;
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
		logger.info("Received request to register user");
		return service.addUser(user);
		
	}
	
	@GetMapping("/get/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public UserDTO findById(@PathVariable Long id) throws Exception{
		logger.info("Received request to get user details for userid:{}",id);
		 UserDTO user= service.findById(id);
		   if (user.getId()!= id) {
		             logger.info("User details not found for userId: {}", id);
		             throw new UserNotFoundException(HttpStatus.NOT_FOUND, "userId with userId :"+id+"not found");
		   }
		   return user;
		
		
	}
	@PutMapping("/put/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public UserDTO updateUser(@PathVariable Long id,@RequestBody UserDTO user) {
		logger.info("Received request to update user for userid:{}",user.getId());
		return service.updateUser(user);
	}
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		logger.info("Received request to delete user for userid:{}",id);
		 service.deleteById(id);
	}
	
	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public List<User> findAll(){
		
		  logger.info("Received request to get all registered users");
	         List<User> user= service.findAll();
	   if (user.isEmpty()) {
	             logger.info("No registered users found");
	             throw new UserNotFoundException(HttpStatus.NOT_FOUND, "There are no registered users");
	   }
	   return user;
	 }
}
