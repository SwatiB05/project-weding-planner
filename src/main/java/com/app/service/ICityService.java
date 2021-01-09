package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Cities;

public interface ICityService {
	List<Cities> getAllCities();

<<<<<<< HEAD
	//Cities addCityDetails(Cities transientpojo);
=======
>>>>>>> bc7bf36ab920bc640b138d28ff60915c348694b3
	ResponseEntity<?> addCityDetails(Cities transientpojo);

	ResponseEntity<?> updateCityDetails(int cityId, Cities detachedPOJO);

	ResponseEntity<?> deleteCityById(int cityId);
}
