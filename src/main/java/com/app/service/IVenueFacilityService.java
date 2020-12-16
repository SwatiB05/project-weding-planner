package com.app.service;

import java.util.List;

import com.app.pojos.Venue_Facilities;

public interface IVenueFacilityService {

	List<Venue_Facilities> getAllVenueFacilities();
	
	Venue_Facilities addVenueFacilityDetails(Venue_Facilities v);
	
	Venue_Facilities updateVenueFacilityDetails(int id,Venue_Facilities v);

	void deleteVFacilityById(int id);

}
