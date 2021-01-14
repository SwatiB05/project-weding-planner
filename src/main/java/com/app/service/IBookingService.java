package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Bookings;

public interface IBookingService {

	List<Bookings> getAllBookings();
//	List<Bookings> getAllBookings(int customerId);
	ResponseEntity<?> addBookingDetails(Bookings b);
	
	ResponseEntity<?> updateBookingDetails(int bookingId, Bookings b); 
	
	ResponseEntity<?> deleteBookingById(int id);
	

}
