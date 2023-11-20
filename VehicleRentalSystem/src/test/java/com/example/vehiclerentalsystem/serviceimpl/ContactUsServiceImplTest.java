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


import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.vehiclerentalsystem.dto.ContactUsDTO;
import com.example.vehiclerentalsystem.entity.ContactUs;
import com.example.vehiclerentalsystem.repository.ContactUsRepository;


class ContactUsServiceImplTest {

	 @Mock
	    private PasswordEncoder passwordEncoder;

	    @Mock
	    private ContactUsRepository contactUsRepository;

	    @InjectMocks
	    private ContactUsServiceImpl contactUsService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	    
	    @Test
	    void testRegisterContactUsDetails() {
	   
	        ContactUsDTO contactUsDto = createContactUsDTO();
	        ContactUs contactUs = createContactUs();
	        when(contactUsRepository.save(any(ContactUs.class))).thenReturn(contactUs);
	        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

	        
	        ContactUsDTO result = contactUsService.addDetails(contactUsDto);
	        
	        assertNotNull(result);
	        assertEquals(contactUs.getId(), result.getId());
	        assertEquals(contactUs.getEmail(),result.getEmail());
	        assertEquals(contactUs.getPhoneNumber(),result.getPhoneNumber());
	        
	    }
	    
	    @Test
	    void testEditContactUsDetails() {
	    	
	    	 ContactUsDTO contactUsDto = createContactUsDTO();
		        ContactUs contactUs = createContactUs();
		        when(contactUsRepository.save(any(ContactUs.class))).thenReturn(contactUs);
		        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

		        
		        ContactUsDTO result = contactUsService.addDetails(contactUsDto);
		        
		        assertNotNull(result);
		        assertEquals(contactUs.getId(), result.getId());
		        assertEquals(contactUs.getEmail(),result.getEmail());
		        assertEquals(contactUs.getPhoneNumber(),result.getPhoneNumber());
	    	
	    }
	    
	    @Test
	    void testDeleteContactUsDetails() {
	       
	        int id = 1;

	        
	        contactUsService.deleteById((long) id);

	        
	        verify(contactUsRepository, times(1)).deleteById((long) id);
	    }
	    
	    @Test
	    void testGetById() throws Exception {
	       
	        int id = 1;
	        ContactUs contactUs = createContactUs();
	        when(contactUsRepository.findById((long) id)).thenReturn(Optional.of(contactUs));

	        
	        ContactUsDTO result = contactUsService.findById((long) id);
	        
	        assertNotNull(result);
	        assertEquals(contactUs.getId(), result.getId());
	        assertEquals(contactUs.getEmail(),result.getEmail());
	        assertEquals(contactUs.getPhoneNumber(),result.getPhoneNumber());
	        
	    }
	    
	    private ContactUsDTO createContactUsDTO() {
	        return new ContactUsDTO(1,"xyz@gmail.com","8547963289");
	    }

	    private ContactUs createContactUs() {
	    	 ContactUs contactUs = new ContactUs();
	        contactUs.setId(1);
	        contactUs.setEmail("xyz@gmail.com");
	        contactUs.setPhoneNumber("8547963289");
	        
	       
	        return contactUs ; 
	    }



	        
	    

}
