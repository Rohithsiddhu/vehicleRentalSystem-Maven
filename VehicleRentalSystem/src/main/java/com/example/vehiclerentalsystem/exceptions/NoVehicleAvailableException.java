package com.example.vehiclerentalsystem.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoVehicleAvailableException extends ResponseStatusException {

			public NoVehicleAvailableException(HttpStatus status,String msg) {
	        		super(status,msg);   
		}
	}
