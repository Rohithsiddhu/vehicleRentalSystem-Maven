package com.example.vehiclerentalsystem.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	IUserService service;
	
	
	@PostMapping("/add")
	public UserDTO addUser(@RequestBody UserDTO user) {
		return service.addUser(user);
		
	}
	
	@GetMapping("/get/{id}")
	public UserDTO findById(@PathVariable Long id) throws Exception{
		return service.findById(id);
	}
	@PutMapping("/put/{id}")
	public UserDTO updateUser(@PathVariable Long id,@RequestBody UserDTO user) {
		return service.updateUser(user);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		 service.deleteById(id);
	}

}
