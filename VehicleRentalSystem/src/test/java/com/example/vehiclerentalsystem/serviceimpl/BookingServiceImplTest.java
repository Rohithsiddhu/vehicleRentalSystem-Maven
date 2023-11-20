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

import com.example.vehiclerentalsystem.dto.BookingDTO;
import com.example.vehiclerentalsystem.entity.Booking;
import com.example.vehiclerentalsystem.repository.BookingRepository;



class BookingServiceImpTest {
	 @Mock
	    private PasswordEncoder passwordEncoder;

	    @Mock
	    private BookingRepository bookingRepository;

	    @InjectMocks
	    private BookingServiceImpl bookingService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void testRegisterBooking() {
	   
	        BookingDTO bookingDto = createBookingDTO();
	        Booking booking = createBooking();
	        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);
	        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

	        
	        BookingDTO result = bookingService.addBooking(bookingDto);

	      
	        assertNotNull(result);
	       // assertEquals(booking.getId(), result.getBookingid());
	        assertEquals(booking.getFromDate(),result.getFromDate());
	        assertEquals(booking.getToDate(),result.getToDate());
	        assertEquals(booking.getUser(),result.getUserId());
	        assertEquals(booking.getVehicle(),result.getVehicleId());
	        
	    }
	        

	   

		@Test
	    void testEditBooking() {
	        
			  BookingDTO bookingDto = createBookingDTO();
		        Booking booking = createBooking();
		        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);
		        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");


		        BookingDTO result = bookingService.addBooking(bookingDto);

			      
		        assertNotNull(result);
		       // assertEquals(booking.getId(),  result.getId());
		        assertEquals(booking.getFromDate(),result.getFromDate());
		        assertEquals(booking.getToDate(),result.getToDate());
		        assertEquals(booking.getUser(),result.getUserId());
		        assertEquals(booking.getVehicle(),result.getVehicleId());
		        
		    }


		@Test
	    void testDeleteBooking() {
	       
	        int bookingId = 1;

	        
	        bookingService.deleteById((long) bookingId);

	        
	        verify(bookingRepository, times(1)).deleteById((long) bookingId);
	    }

	    @Test
	    void testGetByBookingId() throws Exception {
	       
	        int bookingId = 1;
	        Booking booking = createBooking();
	        when(bookingRepository.findById((long) bookingId)).thenReturn(Optional.of(booking));

	        
	        BookingDTO result = bookingService.findById((long) bookingId);

	        assertNotNull(result);
	        assertEquals(booking.getId(), result.getId());
	        assertEquals(booking.getFromDate(),result.getFromDate());
	        assertEquals(booking.getToDate(),result.getToDate());
	        assertEquals(booking.getUser(),result.getUserId());
	        assertEquals(booking.getVehicle(),result.getVehicleId());
	    }

	    @Test
	    void testGetAllBookings() {
	        // Arrange
	        Booking booking1 = createBooking();
	        Booking booking2 = createBooking();
	        List<Booking> bookings = List.of(booking1,booking2);
	        when(bookingRepository.findAll()).thenReturn(bookings);

	        
	        List<Booking> result = bookingService.findAll();

	        
	        assertNotNull(result);
	        assertEquals(2, result.size());
	    }

	   


	    private BookingDTO createBookingDTO() {
	        return new BookingDTO();
	    }

	    private Booking createBooking() {
	        Booking booking = new Booking();
	        booking.setId(1);
	        booking.setFromDate(null);
	        booking.setToDate(null);
	        booking.setUser(null);
	        booking.setVehicle(null);
	       
	       
	        return  booking ; 
	    }
}
