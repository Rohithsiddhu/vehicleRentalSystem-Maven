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

import com.example.vehiclerentalsystem.dto.VehicleDTO;
import com.example.vehiclerentalsystem.entity.Vehicle;
import com.example.vehiclerentalsystem.repository.VehicleRepository;


class VehicleServiceImplTest {
	
	 @Mock
	    private PasswordEncoder passwordEncoder;

	    @Mock
	    private VehicleRepository vehicleRepository;

	    @InjectMocks
	    private VehicleServiceImpl vehicleService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	    
	    @Test
	    void testRegisterVehicle() {
	   
	        VehicleDTO vehicleDto = createVehicleDTO();
	        Vehicle vehicle = createVehicle();
	        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);
	        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

	        
	        VehicleDTO result = vehicleService.addVehicle(vehicleDto);

	      
	        assertNotNull(result);
	        assertEquals(vehicle.getId(), result.getId());
	        assertEquals(vehicle.getModelName(),result.getModelName());
	        assertEquals(vehicle.getCapacity(),result.getCapacity());
	        assertEquals(vehicle.getType(),result.getType());
	        assertEquals(vehicle.getCostPerDay(),result.getCostPerDay());
	        assertEquals(vehicle.getMileage(),result.getMileage());
	        assertEquals(vehicle.getRegistrationNumber(),result.getRegistrationNumber());
	        
	        
	    }
	    
	    @Test
	    void testEditBooking() {
	    	
	    	 VehicleDTO vehicleDto = createVehicleDTO();
		        Vehicle vehicle = createVehicle();
		        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);
		        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

		        
		        VehicleDTO result = vehicleService.addVehicle(vehicleDto);

		      
		        assertNotNull(result);
		        assertEquals(vehicle.getId(), result.getId());
		        assertEquals(vehicle.getModelName(),result.getModelName());
		        assertEquals(vehicle.getCapacity(),result.getCapacity());
		        assertEquals(vehicle.getType(),result.getType());
		        assertEquals(vehicle.getCostPerDay(),result.getCostPerDay());
		        assertEquals(vehicle.getMileage(),result.getMileage());
		        assertEquals(vehicle.getRegistrationNumber(),result.getRegistrationNumber());
		        
	    }
	    
		@Test
	    void testDeleteVehicle() {
	       
	        int vehicleId = 1;

	        
	        vehicleService.deleteById((long) vehicleId);

	        
	        verify(vehicleRepository, times(1)).deleteById((long) vehicleId);
	    }
		
		 @Test
		    void testGetByVehicleId() throws Exception {
		       
		        int vehicleId = 1;
		       Vehicle vehicle = createVehicle();
		        when(vehicleRepository.findById((long) vehicleId)).thenReturn(Optional.of(vehicle));

		        
		        VehicleDTO result = vehicleService.findById((long) vehicleId);
		        
		        assertNotNull(result);
		        assertEquals(vehicle.getId(), result.getId());
		        assertEquals(vehicle.getModelName(),result.getModelName());
		        assertEquals(vehicle.getCapacity(),result.getCapacity());
		        assertEquals(vehicle.getType(),result.getType());
		        assertEquals(vehicle.getCostPerDay(),result.getCostPerDay());
		        assertEquals(vehicle.getMileage(),result.getMileage());
		        assertEquals(vehicle.getRegistrationNumber(),result.getRegistrationNumber());
		 }
		 
		 @Test
		    void testGetAllVehicles() {
		        // Arrange
		        Vehicle vehicle1 = createVehicle();
		        Vehicle vehicle2 = createVehicle();
		        List<Vehicle> vehicles = List.of(vehicle1,vehicle2);
		        when(vehicleRepository.findAll()).thenReturn(vehicles);

		        
		        List<Vehicle> result = vehicleService.findAll();

		        
		        assertNotNull(result);
		        assertEquals(2, result.size());
		    }
		 
		 private VehicleDTO createVehicleDTO() {
		        return new VehicleDTO(1,"Safari",7,"Diesel",2000.0f ,20.0f,"AP78945");
		    }

		    private Vehicle createVehicle() {
		        Vehicle vehicle = new Vehicle();
		        vehicle.setId(1);
		        vehicle.setModelName("Safari");
		        vehicle.setCapacity(7);
		        vehicle.setType("Diesel");
		        vehicle.setCostPerDay(2000.0f);
		        vehicle.setMileage(20.0f);
		        vehicle.setRegistrationNumber("AP78945");
		       
		       
		        return  vehicle ; 
		    }



		
	        

	
	

}
