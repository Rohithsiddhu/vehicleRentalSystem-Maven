package com.example.vehiclerentalsystem.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.vehiclerentalsystem.entity.User;
import com.example.vehiclerentalsystem.repository.UserRepository;

@Component
public class UserRolesService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByName(username);

	    if (user.isPresent()) {
	        return user.map(UserRoles::new)
	                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
	    }
		return null;
	}

}
