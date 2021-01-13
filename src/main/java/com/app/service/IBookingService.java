package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Bookings;

public interface IBookingService {

	List<Bookings> getAllBookings();
	Bookings getBooking(int id);
	ResponseEntity<?> addBookingDetails(Bookings b);
	
	ResponseEntity<?> updateBookingDetails(int bookingId, Bookings b); 
	
	ResponseEntity<?> deleteBookingById(int id);

}
