package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Facilities;

public interface IFacilitesService {

	List<Facilities> getAllFacilities();

	ResponseEntity<?> addFacilityDetails(Facilities f);

	ResponseEntity<?> updateFacilityDetails(int facilityId, Facilities f);

	ResponseEntity<?> deleteFacilityById(int id);
	ResponseEntity<?> findById(int id);

}
