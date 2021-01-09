package com.app.service;

import java.util.List;

import com.app.pojos.VenueFacilities;

public interface IVenueFacilityService {

	List<VenueFacilities> getAllVenueFacilities();
	
	VenueFacilities addVenueFacilityDetails(VenueFacilities v);
	
	VenueFacilities updateVenueFacilityDetails(int id,VenueFacilities v);

	void deleteVenueFacilityById(int id);

}
