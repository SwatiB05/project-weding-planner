package com.app.service;

import java.util.List;

import com.app.pojos.Venues;

public interface IVenueService {

	List<Venues> getAllVenues();

	Venues addVenueDetails(Venues v);

	Venues updateVenueDetails(int venueId, Venues v);

	void deleteVenueById(int id);

}
