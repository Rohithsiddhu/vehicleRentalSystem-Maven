package com.example.vehiclerentalsystem.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclerentalsystem.dto.UserDTO;
import com.example.vehiclerentalsystem.service.IJwtTokenService;

@RestController
@RequestMapping("/api/jwtToken")
public class JwtTokenController {
	@Autowired
	IJwtTokenService jwtTokenService;
	@GetMapping("/get/{userName}")
	public String findById(@PathVariable String userName) throws Exception{
		return jwtTokenService.getToken(userName);
	}

}
