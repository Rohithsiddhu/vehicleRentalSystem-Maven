package com.example.vehiclerentalsystem.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.vehiclerentalsystem.service.IVehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleRestController {
	private @Autowired
	IVehicleService service;
	
	
	
	public VehicleRestController(IVehicleService service) {
		super();
		this.service = service;
	}
	@PostMapping("/add")
	public VehicleDTO addVehicle(@RequestBody VehicleDTO vehicleDTO) {
		return service.addVehicle(vehicleDTO);
		
	}
	@PutMapping("/update/{id}")
	public VehicleDTO updateVehicle(@PathVariable Long id,@RequestBody VehicleDTO vehicle) {
		return service.updateVehicle(vehicle);
	}
	@GetMapping("/get/{id}")
	public VehicleDTO getById(@PathVariable Long id) throws Exception {
		return service.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
	@GetMapping("/getall")
	public List<Vehicle> getAll(){
		return service.findAll();
	}
	
	

}
