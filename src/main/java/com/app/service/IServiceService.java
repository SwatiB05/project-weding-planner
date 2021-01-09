package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Services;

public interface IServiceService {

	List<Services> getAllServices();
	
	ResponseEntity<?> addServiceDetails(Services s);
	
	ResponseEntity<?> updateServiceDetails(int Id,Services s);
	
	ResponseEntity<?> deleteServiceById(int Id);

}
