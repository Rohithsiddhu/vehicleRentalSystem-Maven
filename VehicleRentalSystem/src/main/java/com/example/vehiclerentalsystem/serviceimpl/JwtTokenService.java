package com.example.vehiclerentalsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalsystem.config.JwtUtil;
import com.example.vehiclerentalsystem.service.IJwtTokenService;

@Service
public class JwtTokenService implements IJwtTokenService{
	 @Autowired
	   private JwtUtil jwtUtil;
	@Override
	public String getToken(String userName) {
		return jwtUtil.generateToken(userName);
	}

}
