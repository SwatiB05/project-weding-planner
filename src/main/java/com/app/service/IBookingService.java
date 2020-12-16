package com.app.service;

import java.util.List;

import com.app.pojos.Bookings;

public interface IBookingService {

	List<Bookings> getAllBookings();
	
	Bookings addBookingDetails(Bookings b);
	
	Bookings updateBookingDetails(int bookingId, Bookings b); 
	
	void deleteBookingById(int id);

}
