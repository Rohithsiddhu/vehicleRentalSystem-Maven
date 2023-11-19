package com.example.vehiclerentalsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vehiclerentalsystem.entity.User;

public interface UserRepository  extends JpaRepository<User,Long>{
	
	Optional<User> findByName(String name);

}
