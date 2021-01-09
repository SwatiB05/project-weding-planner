package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.ResourceNotFoundException;
import com.app.dao.IVenueDao;
import com.app.pojos.VenueFacilities;
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
	public Venues addVenueDetails(Venues v) {
		// TODO Auto-generated method stub
		return dao.save(v);
	}

	@Override
	public Venues updateVenueDetails(int venueId, Venues detachedPOJO) {
		// TODO Auto-generated method stub
		Optional<Venues>v=dao.findById(venueId);
		
		if(v.isPresent()) {
			Venues venue=v.get();
		venue.setDescription(detachedPOJO.getDescription());
		venue.setEmail(detachedPOJO.getDescription());
		venue.setGuestCapacity(detachedPOJO.getGuestCapacity());
		venue.setImage(detachedPOJO.getImage());
		venue.setPhoneNo(detachedPOJO.getPhoneNo());
		venue.setVcityId(detachedPOJO.getVcityId());
		venue.setVenueFacilities(detachedPOJO.getVenueFacilities());
		venue.setVenueAddress(detachedPOJO.getVenueAddress());
		venue.setVenueName(detachedPOJO.getVenueName());
		return venue;
	}
		throw new ResourceNotFoundException("No such venue...");
		}

	@Override
	public void deleteVenueById(int id) {
		Optional<Venues> c = dao.findById(id);
		if (c.isPresent()) {
			dao.deleteById(id);
		}
		throw new ResourceNotFoundException("Invalid Venue ID");
	}

}
