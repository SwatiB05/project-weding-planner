package com.app.service;

import java.util.List;

import com.app.pojos.Facilities;

public interface IFacilitesService {

	List<Facilities> getAllFacilities();

	Facilities addFacilityDetails(Facilities f);

	Facilities updateFacilityDetails(int facilityId, Facilities f);

	void deleteFacilityById(int id);

}
