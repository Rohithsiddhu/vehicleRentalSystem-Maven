package com.example.vehiclerentalsystem.exceptions;
	
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VehicleNotFoundException extends ResponseStatusException {

			public VehicleNotFoundException(HttpStatus status,String msg) {
				super(status,msg);   

		}
	}
