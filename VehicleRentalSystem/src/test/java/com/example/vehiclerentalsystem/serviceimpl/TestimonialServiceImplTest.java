package com.example.vehiclerentalsystem.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.vehiclerentalsystem.dto.TestimonialDTO;
import com.example.vehiclerentalsystem.entity.Testimonial;

import com.example.vehiclerentalsystem.repository.TestimonialRepository;


class TestimonialServiceImplTest {

	@Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private TestimonialRepository testimonialRepository;

    @InjectMocks
    private TestimonialServiceImpl testimonialService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
    }
    
    @Test
    void testRegisterTestimonial() {
   
        TestimonialDTO testimonialDto = createTestimonialDTO();
        Testimonial testimonial = createTestimonial();
        when(testimonialRepository.save(any(Testimonial.class))).thenReturn(testimonial);
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

        
        TestimonialDTO result = testimonialService.addTestimonial(testimonialDto);
        
        assertNotNull(result);
        assertEquals(testimonial.getTestimonialid(), result.getTestimonialsid());
        assertEquals(testimonial.getUserid(), result.getUserid());
        assertEquals(testimonial.getFeedback(), result.getFeedback());
        assertEquals(testimonial.isIsactive(), result.isIsactive());
                 
    }
    
    @Test
    void testEditTestimonial() {
    	
    	TestimonialDTO testimonialDto = createTestimonialDTO();
        Testimonial testimonial = createTestimonial();
        when(testimonialRepository.save(any(Testimonial.class))).thenReturn(testimonial);
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

        
        TestimonialDTO result = testimonialService.addTestimonial(testimonialDto);
        
        assertNotNull(result);
        assertEquals(testimonial.getTestimonialid(), result.getTestimonialsid());
        assertEquals(testimonial.getUserid(), result.getUserid());
        assertEquals(testimonial.getFeedback(), result.getFeedback());
        assertEquals(testimonial.isIsactive(), result.isIsactive());
    		
    }
    
    @Test
    void testGetByTestimonialId() throws Exception {
       
        int TestimonialsId = 1;
       Testimonial testimonial= createTestimonial();
        when(testimonialRepository.findById((long) TestimonialsId)).thenReturn(Optional.of(testimonial));

        
        TestimonialDTO result = testimonialService.findById((long) TestimonialsId);
        
        assertNotNull(result);
        assertEquals(testimonial.getTestimonialid(), result.getTestimonialsid());
        assertEquals(testimonial.getUserid(), result.getUserid());
        assertEquals(testimonial.getFeedback(), result.getFeedback());
        assertEquals(testimonial.isIsactive(), result.isIsactive());
        
    }
    
    
	 @Test
	    void testGetAllTestimonials() {
	        // Arrange
	        Testimonial testimonial1 = createTestimonial();
	        Testimonial testimonial2 = createTestimonial();
	        List<Testimonial> testimonials = List.of(testimonial1,testimonial2);
	        when(testimonialRepository.findAll()).thenReturn(testimonials);

	        
	        List<TestimonialDTO> result = testimonialService.getAll();

	        
	        assertNotNull(result);
	        assertEquals(2, result.size());
	    }
	 
	 private TestimonialDTO createTestimonialDTO() {
	        return new TestimonialDTO(1,5,"Good",true);
	    }

	    private Testimonial createTestimonial() {
	        Testimonial testimonial = new Testimonial();
	        testimonial.setTestimonialid(1);
	        testimonial.setUserid(5);
	        testimonial.setFeedback("Good");
	        testimonial.setIsactive(true);
	        
	       
	       
	        return  testimonial ; 
	    }

}
