package com.example.vehiclerentalsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalsystem.entity.Login;
import com.example.vehiclerentalsystem.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository repo;
	
	public Login login(String username,String password) {
		Login login = repo.findByUsernameAndPassword(username,password);
		return login;
	}

}
