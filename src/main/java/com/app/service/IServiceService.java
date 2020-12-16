package com.app.service;

import java.util.List;

import com.app.pojos.Services;

public interface IServiceService {

	List<Services> getAllServices();
	
	Services addServiceDetails(Services s);
	
	Services updateServiceDetails(int Id,Services s);
	
	void deleteServiceById(int Id);

}
