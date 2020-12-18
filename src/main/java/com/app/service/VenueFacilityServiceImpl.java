package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.ResourceNotFoundException;
import com.app.dao.IVenueFacilitiesDao;
import com.app.pojos.Venue_Facilities;

@Service
@Transactional
public class VenueFacilityServiceImpl implements IVenueFacilityService {

	@Autowired
	private IVenueFacilitiesDao dao;
	@Override
	public List<Venue_Facilities> getAllVenueFacilities() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteVFacilityById(int id) {
		// TODO Auto-generated method stub
dao.deleteById(id);
	}

	@Override
	public Venue_Facilities addVenueFacilityDetails(Venue_Facilities v) {
		// TODO Auto-generated method stub
		return dao.save(v);
	}

	@Override
	public Venue_Facilities updateVenueFacilityDetails(int id, Venue_Facilities detachedPOJO) {
		Optional<Venue_Facilities> v = dao.findById(id);
		if (v.isPresent()) {
			Venue_Facilities facility = v.get();
			facility.setBookings(detachedPOJO.getBookings());
			facility.setCharges(detachedPOJO.getCharges());
			facility.setFacilityId(detachedPOJO.getFacilityId());
			facility.setVenueId(detachedPOJO.getVenueId());
			
			return facility;

		}
		throw new ResourceNotFoundException("Invalid Venue-Facility...");

	}

}
