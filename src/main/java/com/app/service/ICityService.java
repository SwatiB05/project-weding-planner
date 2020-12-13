package com.app.service;

import java.util.List;

import com.app.pojos.Cities;

public interface ICityService {
	List<Cities> getAllCities();

	Cities addCityDetails(Cities transientpojo);

	Cities updateCityDetails(int cityId, Cities detachedPOJO);

	void deleteCityById(int cityId);
}
