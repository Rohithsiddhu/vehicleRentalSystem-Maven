package com.example.vehiclerentalsystem.restcontroller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.vehiclerentalsystem.dto.VehicleDTO;
import com.example.vehiclerentalsystem.entity.Vehicle;
import com.example.vehiclerentalsystem.exceptions.VehicleNotFoundException;
import com.example.vehiclerentalsystem.service.IVehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleRestController {
	Logger logger = LoggerFactory.getLogger(VehicleRestController.class);
	
	
	private @Autowired
	IVehicleService service;
	
	
	
	public VehicleRestController(IVehicleService service) {
		super();
		this.service = service;
	}
	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public VehicleDTO addVehicle(@RequestBody VehicleDTO vehicleDTO) {
		logger.info("Received request to add vehicle");
		return service.addVehicle(vehicleDTO);
		
	}
	@PutMapping("/update/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public VehicleDTO updateVehicle(@PathVariable Long id,@RequestBody VehicleDTO vehicle) {
		logger.info("Received request to update  vehicle for Id: {}", vehicle.getId());
		return service.updateVehicle(vehicle);
	}
	@GetMapping("/get/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN,ROLE_USER')")
	public VehicleDTO getById(@PathVariable Long id) throws Exception {
		 logger.warn("Vehicle not found for id: {}", id);
        // throw new VehicleNotFoundException(HttpStatus.NOT_FOUND,"Vehicle not found for Id:"+ id);
	
		return service.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public List<Vehicle> getAll(){
		 logger.info("Received request to delete vehicle for Id");
		return service.findAll();
	}
	
	

}
