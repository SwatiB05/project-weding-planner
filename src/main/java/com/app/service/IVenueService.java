package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Venues;

public interface IVenueService {

	List<Venues> getAllVenues();

	ResponseEntity<?> addVenueDetails(Venues v);

	ResponseEntity<?> updateVenueDetails(int venueId, Venues v);

	ResponseEntity<?> deleteVenueById(int id);
	ResponseEntity<?> findById(int id);

}
