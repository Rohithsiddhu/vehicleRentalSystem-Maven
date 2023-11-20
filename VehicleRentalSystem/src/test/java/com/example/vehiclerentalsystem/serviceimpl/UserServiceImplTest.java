package com.example.vehiclerentalsystem.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.vehiclerentalsystem.entity.User;
import com.example.vehiclerentalsystem.dto.UserDTO;
import com.example.vehiclerentalsystem.repository.UserRepository;


class UserServiceImpTest {
	 @Mock
	    private PasswordEncoder passwordEncoder;

	    @Mock
	    private UserRepository userRepository;

	    @InjectMocks
	    private UserServiceImpl userService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void testRegisterUser() {
	   
	        UserDTO userDto = createUserDTO();
	        User user = createUser();
	        when(userRepository.save(any(User.class))).thenReturn(user);
	        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

	        
	        UserDTO result = userService.addUser(userDto);

	      
	        assertNotNull(result);
	        assertEquals(user.getId(), result.getId());
	        assertEquals(user.getEmail(), result.getEmail());
	        assertEquals("encodedPassword", result.getPassword());
	        assertEquals(user.getName(), result.getName());
	        assertEquals(user.getContactNumber(), result.getContactNumber());
	        assertEquals(user.getAddress(), result.getAddress());
	        assertEquals(user.getAadhar(), result.getAadhar());
	        assertEquals(user.getDrivingLicence(), result.getDrivingLicence());
	        assertEquals(user.getRoles(), result.getRoles());
	    }

	    @Test
	    void testEditUserProfile() {
	        
	        UserDTO userDto = createUserDTO();
	        User user = createUser();
	        when(userRepository.save(any(User.class))).thenReturn(user);
	        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

	        
	        UserDTO result = userService.updateUser(userDto);

	        assertNotNull(result);
	        assertEquals(user.getId(), result.getId());
	        assertEquals(user.getEmail(), result.getEmail());
	        assertEquals("encodedPassword", result.getPassword());
	        assertEquals(user.getName(), result.getName());
	        assertEquals(user.getContactNumber(), result.getContactNumber());
	        assertEquals(user.getAddress(), result.getAddress());
	        assertEquals(user.getAadhar(), result.getAadhar());
	        assertEquals(user.getDrivingLicence(), result.getDrivingLicence());
	        assertEquals(user.getRoles(), result.getRoles());
	    }

	    @Test
	    void testDeleteUserProfile() {
	       
	        int userId = 1;

	        
	        userService.deleteById((long) userId);

	        
	        verify(userRepository, times(1)).deleteById((long) userId);
	    }

	    @Test
	    void testGetByUserId() throws Exception {
	       
	        int userId = 1;
	        User user = createUser();
	        when(userRepository.findById((long) userId)).thenReturn(Optional.of(user));

	        
	        UserDTO result = userService.findById((long) userId);

	        
	        assertNotNull(result);
	        assertEquals(user.getId(), result.getId());
	        assertEquals(user.getEmail(), result.getEmail());
	        assertEquals("encodedPassword", result.getPassword());
	        assertEquals(user.getName(), result.getName());
	        assertEquals(user.getContactNumber(), result.getContactNumber());
	        assertEquals(user.getAddress(), result.getAddress());
	        assertEquals(user.getAadhar(), result.getAadhar());
	        assertEquals(user.getDrivingLicence(), result.getDrivingLicence());
	        assertEquals(user.getRoles(), result.getRoles());
	    }

	    @Test
	    void testGetAllUsers() {
	        // Arrange
	        User user1 = createUser();
	        User user2 = createUser();
	        List<User> users = List.of(user1, user2);
	        when(userRepository.findAll()).thenReturn(users);

	        
	        List<User> result = userService.findAll();

	        
	        assertNotNull(result);
	        assertEquals(2, result.size());
	    }

	   


	    private UserDTO createUserDTO() {
	        return new UserDTO();
	    }

	    private User createUser() {
	        User user = new User();
	        user.setId(1);
	        user.setEmail("abc@example.com");
	        user.setPassword("password");
	        user.setName("Abhay");
	        user.setContactNumber("1234567890");
	        user.setAadhar("546789123456");
	        user.setDrivingLicence("APDL456789");
	        user.setAddress("Address");
	        user.setRoles(null);
	        
	        
	       
	        return user;
	    }
}