package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.VenueFacilities;

public interface IVenueFacilityService {

	List<VenueFacilities> getAllVenueFacilities();
	
	ResponseEntity<?> addVenueFacilityDetails(VenueFacilities v);
	
	ResponseEntity<?> updateVenueFacilityDetails(int id,VenueFacilities v);

	ResponseEntity<?> deleteVenueFacilityById(int id);

}
