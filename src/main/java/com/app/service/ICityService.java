package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Cities;

public interface ICityService {
	List<Cities> getAllCities();


	ResponseEntity<?> addCityDetails(Cities transientpojo);

	ResponseEntity<?> updateCityDetails(int city, Cities detachedPOJO);

	ResponseEntity<?> deleteCityById(int cityId);
	ResponseEntity<?> findById(int id); 
	
}
