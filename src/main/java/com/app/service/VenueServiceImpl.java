package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVenueDao;
import com.app.pojos.Cities;
import com.app.pojos.Venues;

@Service
@Transactional
public class VenueServiceImpl implements IVenueService {

	@Autowired
	private IVenueDao dao;

	@Override
	public List<Venues> getAllVenues() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public ResponseEntity<?> findById(int id) {
		Optional<Venues> c = dao.findById(id);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else
			return ResponseEntity.badRequest().body("Cannot find the specified Venue");
	}

	@Override
	public ResponseEntity<?> addVenueDetails(Venues v) {
	
		dao.save(v);
		return ResponseEntity.ok("Venue Created Successfully");
	}

	@Override
	public ResponseEntity<?> updateVenueDetails(int venueId, Venues detachedPOJO) {
		// TODO Auto-generated method stub
		Optional<Venues> v = dao.findById(venueId);

		if (v.isPresent()) {
			Venues venue = v.get();
			venue.setDescription(detachedPOJO.getDescription());
			venue.setEmail(detachedPOJO.getDescription());
			venue.setGuestCapacity(detachedPOJO.getGuestCapacity());
			venue.setImage(detachedPOJO.getImage());
			venue.setPhoneNo(detachedPOJO.getPhoneNo());
			venue.setVcityId(detachedPOJO.getVcityId());
			venue.setVenueFacilities(detachedPOJO.getVenueFacilities());
			venue.setVenueAddress(detachedPOJO.getVenueAddress());
			venue.setVenueName(detachedPOJO.getVenueName());
			return ResponseEntity.accepted().body("Venue updated successfully");
		} else
			return ResponseEntity.badRequest().body("Cannot find the Venue specified");
	}

	@Override
	public ResponseEntity<?> deleteVenueById(int id) {
		Optional<Venues> c = dao.findById(id);
		if (c.isPresent()) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("Successfully deleted the specified Venue");
		} else {
			return ResponseEntity.badRequest().body("Cannot find the specified Venue");
		}

	}
}
