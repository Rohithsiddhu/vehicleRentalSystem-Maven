package com.example.vehiclerentalsystem.config;

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
	    private List<GrantedAuthority> authorities;
	    
	    public UserRoles(User user) {
	        name=user.getName();
	        password=user.getPassword();
	        authorities= user.getRoles().stream().map(r->r.getName())
	        		.map(SimpleGrantedAuthority::new)
	        		.collect(Collectors.toList());
	    }

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return false;
		}
		
}
