package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.ResourceNotFoundException;
import com.app.dao.IFacilityDao;
import com.app.pojos.Cities;
import com.app.pojos.Customers;
import com.app.pojos.Facilities;

@Service
@Transactional
public class FacilityServiceImpl implements IFacilitesService {

	@Autowired
	private IFacilityDao dao;

	@Override
	public List<Facilities> getAllFacilities() {
		return dao.findAll();
	}
	
	@Override
	public ResponseEntity<?> findById(int id) {
		Optional<Facilities> c = dao.findById(id);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else
			return ResponseEntity.badRequest().body("Cannot find the specified Facility");
	}

	@Override
	public ResponseEntity<?> addFacilityDetails(Facilities f) {
		Optional<Facilities> c = dao.findByFacilityName(f.getFacilityName());
		if (c.isPresent()) {
			return ResponseEntity.badRequest().body("The Facility is already Present, Fail to create");
		} else {
			dao.save(f);
			return ResponseEntity.ok("Facility Created Successfully");
		}
	}

	@Override
	public ResponseEntity<?> updateFacilityDetails(int facilityId, Facilities detachedPOJO) {
		// TODO Auto-generated method stub
		Optional<Facilities> f = dao.findById(facilityId);
		if (f.isPresent()) {
			Facilities facility = f.get();
			facility.setFacilityName(detachedPOJO.getFacilityName());
			return ResponseEntity.accepted().body("Facility updated successfully"); 
		}
		else return ResponseEntity.badRequest().body("Cannot find the specified Facility");
	}

	@Override
	public ResponseEntity<?> deleteFacilityById(int id) {
		Optional<Facilities> c = dao.findById(id);
		if (c.isPresent()) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("Successfully deleted the specified facility");
		} else {
			return ResponseEntity.badRequest().body("Cannot find the facility specified");
		}
	}

}
