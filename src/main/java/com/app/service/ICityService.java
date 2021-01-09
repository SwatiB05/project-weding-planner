package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Cities;

public interface ICityService {
	List<Cities> getAllCities();

	//Cities addCityDetails(Cities transientpojo);
	ResponseEntity<?> addCityDetails(Cities transientpojo);

	ResponseEntity<?> updateCityDetails(int cityId, Cities detachedPOJO);

	ResponseEntity<?> deleteCityById(int cityId);
}
