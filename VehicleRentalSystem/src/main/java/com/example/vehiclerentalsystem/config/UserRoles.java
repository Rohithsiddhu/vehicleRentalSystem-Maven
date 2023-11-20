package com.example.vehiclerentalsystem.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.vehiclerentalsystem.entity.User;
import com.example.vehiclerentalsystem.repository.UserRepository;




public class UserRoles implements UserDetails{
	
	 private String name;
	    private String password;
	    private Collection<? extends GrantedAuthority> authorities;
	    
	    public UserRoles(User user) {
	        name=user.getName();
	        password=user.getPassword();
	        authorities= Arrays.asList(user.getRoles()).stream() .map(SimpleGrantedAuthority::new)
	                .collect(Collectors.toList());

	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public String getUsername() {
	        return name;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
		
}
