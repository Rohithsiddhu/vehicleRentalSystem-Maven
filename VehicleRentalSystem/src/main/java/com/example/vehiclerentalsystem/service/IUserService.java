package com.example.vehiclerentalsystem.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.vehiclerentalsystem.dto.UserDTO;
import com.example.vehiclerentalsystem.entity.User;

public interface IUserService {
	public UserDTO addUser(UserDTO user);
	public UserDTO updateUser(UserDTO user);
	public UserDTO findById(Long id) throws Exception;
	public void deleteById(Long id);
	public List<User> findAll();

	

}
