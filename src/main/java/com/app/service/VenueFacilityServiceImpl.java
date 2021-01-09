package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.ResourceNotFoundException;
import com.app.dao.IVenueFacilitiesDao;
import com.app.pojos.Suppliers;
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
	public void deleteVenueFacilityById(int id) {
		Optional<VenueFacilities> c = dao.findById(id);
		if (c.isPresent()) {
			dao.deleteById(id);
		}
		throw new ResourceNotFoundException("Invalid VenueFacility ID");
	}

	@Override
	public VenueFacilities addVenueFacilityDetails(VenueFacilities v) {
		// TODO Auto-generated method stub
		return dao.save(v);
	}

	@Override
	public VenueFacilities updateVenueFacilityDetails(int id, VenueFacilities detachedPOJO) {
		Optional<VenueFacilities> v = dao.findById(id);
		if (v.isPresent()) {
			VenueFacilities facility = v.get();
			facility.setBookings(detachedPOJO.getBookings());
			facility.setCharges(detachedPOJO.getCharges());
			facility.setFacilityId(detachedPOJO.getFacilityId());
			facility.setVenueId(detachedPOJO.getVenueId());
			
			return facility;

		}
		throw new ResourceNotFoundException("Invalid Venue-Facility...");

	}

}
