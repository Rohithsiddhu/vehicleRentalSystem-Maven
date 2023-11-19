package com.example.vehiclerentalsystem.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalsystem.dto.UserDTO;
import com.example.vehiclerentalsystem.entity.User;
import com.example.vehiclerentalsystem.repository.UserRepository;
import com.example.vehiclerentalsystem.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository repository;

	@Override
	public UserDTO addUser(UserDTO userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		user =  repository.save(user);
		BeanUtils.copyProperties(user,userDto);
		return userDto;
	}

	@Override
	public UserDTO updateUser(UserDTO userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		user =  repository.save(user);
		BeanUtils.copyProperties(user,userDto);
		return userDto;
	}

	@Override
	public UserDTO findById(Long id) throws Exception{
		UserDTO userDto = new UserDTO();
		User user =  repository.findById(id).orElseThrow(() -> new Exception("User not found - " + id));
		BeanUtils.copyProperties(user,userDto);
		return userDto;		
				
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

}
