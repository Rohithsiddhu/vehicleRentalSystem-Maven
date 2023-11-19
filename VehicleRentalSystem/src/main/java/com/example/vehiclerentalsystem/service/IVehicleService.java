package com.example.vehiclerentalsystem.service;

import java.util.List;

import com.example.vehiclerentalsystem.dto.VehicleDTO;
import com.example.vehiclerentalsystem.entity.Vehicle;

public interface IVehicleService {
	public VehicleDTO addVehicle(VehicleDTO vehicle);
	public VehicleDTO updateVehicle(VehicleDTO vehicle);
	public VehicleDTO findById(Long id) throws Exception;
	public void deleteById(Long id);
	public List<Vehicle> findAll();
	

}
