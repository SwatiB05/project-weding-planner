package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Cities;

public interface ICityService {
	List<Cities> getAllCities();


	ResponseEntity<?> addCityDetails(Cities transientpojo);

	ResponseEntity<?> updateCityDetails(String city, Cities detachedPOJO);

	ResponseEntity<?> deleteCityById(int cityId);
	ResponseEntity<?> findById(int id); 
	ResponseEntity<?> findByName(String name); 
}
