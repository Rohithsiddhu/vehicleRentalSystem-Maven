package com.example.vehiclerentalsystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalsystem.dto.VehicleDTO;
import com.example.vehiclerentalsystem.entity.Vehicle;
import com.example.vehiclerentalsystem.repository.VehicleRepository;
import com.example.vehiclerentalsystem.service.IVehicleService;

@Service
public class VehicleServiceImpl implements IVehicleService {
	Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);

	@Autowired
	private VehicleRepository vehicleRepository;
	
	

	@Override
	public VehicleDTO findById(Long id) throws Exception {
		VehicleDTO vehicleDTO = new VehicleDTO();
		Vehicle vehicle =  vehicleRepository.findById(id).orElseThrow(() -> new Exception("Vehicle not found - " + id));
		//vehicleDTO.setCapacity(vehicle.getCapacity());
		BeanUtils.copyProperties(vehicle, vehicleDTO);
		logger.info("Vehicle found with"+id);
		return vehicleDTO;
		// return repository.findById(id).orElse(null);

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
		vehicleRepository.deleteById(id);
		logger.info("Vehicle Deleted Successfully");
	}

	@Override
	public VehicleDTO addVehicle(VehicleDTO vehicleDto) {
		
		Vehicle vehicle = new Vehicle();
		BeanUtils.copyProperties(vehicleDto, vehicle);
		vehicle = vehicleRepository.save(vehicle);
		BeanUtils.copyProperties(vehicle,vehicleDto);
		logger.info("Vehicle added successfully");
		return vehicleDto;
	}

	@Override
	public VehicleDTO updateVehicle(VehicleDTO vehicleDto) {
		Vehicle vehicle = new Vehicle();
		BeanUtils.copyProperties(vehicleDto, vehicle);
		vehicle = vehicleRepository.save(vehicle);
		BeanUtils.copyProperties(vehicle,vehicleDto);
		logger.info("Vehicle updated successfully");
		return vehicleDto;
		
	}

	@Override
	public List<Vehicle> findAll() {

	// List<VehicleDTO> vehicleDtoList = new ArrayList<>();
	 
	 List<Vehicle> vehicleList = vehicleRepository.findAll();
	 logger.info("the size of get all vehicles: "+vehicleList.size());
	
	 
	 return vehicleList;
	 }

	

}
