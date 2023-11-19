package com.example.vehiclerentalsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vehiclerentalsystem.entity.Login;
import com.example.vehiclerentalsystem.entity.User;

public interface LoginRepository extends JpaRepository<Login,Long>{
	
	Login findByUsernameAndPassword(String username,String password);

}
