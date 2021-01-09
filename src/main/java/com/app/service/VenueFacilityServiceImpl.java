package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVenueFacilitiesDao;
import com.app.pojos.VenueFacilities;

@Service
@Transactional
public class VenueFacilityServiceImpl implements IVenueFacilityService {

	@Autowired
	private IVenueFacilitiesDao dao;
	@Override
	public List<VenueFacilities> getAllVenueFacilities() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public ResponseEntity<?> deleteVenueFacilityById(int id) {
		Optional<VenueFacilities> c = dao.findById(id);
		if (c.isPresent()) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("Successfully deleted the specified VenueFacilitie");
		} else {
			return ResponseEntity.badRequest().body("Cannot find the specified VenueFacilitie");
		}
		}

	@Override
	public ResponseEntity<?> addVenueFacilityDetails(VenueFacilities v) {
		// TODO Auto-generated method stub
		Optional<VenueFacilities> c = dao.findById(v.getVenueFacilityId());
		if (c.isPresent()) {
			return ResponseEntity.badRequest().body("The VenueFacilitie is already Present, Fail to create");
		} else {
			dao.save(v);
			return ResponseEntity.ok("VenueFacilitie Created Successfully");
		}
	}

	@Override
	public ResponseEntity<?> updateVenueFacilityDetails(int id, VenueFacilities detachedPOJO) {
		Optional<VenueFacilities> v = dao.findById(id);
		if (v.isPresent()) {
			VenueFacilities facility = v.get();
			facility.setBookings(detachedPOJO.getBookings());
			facility.setCharges(detachedPOJO.getCharges());
			facility.setFacilityId(detachedPOJO.getFacilityId());
			facility.setVenueId(detachedPOJO.getVenueId());
			
			return  ResponseEntity.accepted().body("VenueFacility updated successfully"); 

		}
		else return ResponseEntity.badRequest().body("Cannot find the VenueFacility specified");

	}

}
