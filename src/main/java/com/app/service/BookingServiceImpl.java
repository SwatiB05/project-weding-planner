package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.ResourceNotFoundException;
import com.app.dao.IBookingDao;
import com.app.pojos.Bookings;
import com.app.pojos.Cities;
@Service
@Transactional
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingDao dao;
		
	@Override
	public List<Bookings> getAllBookings() {
		return dao.findAll();
	}
	
	
	@Override
	public ResponseEntity<?> addBookingDetails(Bookings b) {
		Optional<Bookings> c = dao.findById(b.getBookingId());
		if (c.isPresent()) {
			 return ResponseEntity.badRequest().body("The bookings is already Present, Fail to create");
		}
		dao.save(b);
		return ResponseEntity.ok("Booking Created Successfully");
	}

	@Override
	public ResponseEntity<?> updateBookingDetails(int bookingId, Bookings detachedPOJO) {
		Optional<Bookings> c = dao.findById(bookingId);
		if (c.isPresent()) {
			Bookings booking = c.get();
			booking.setVenueFacilityDetails(detachedPOJO.getVenueFacilityDetails());
			booking.setBookingName(detachedPOJO.getBookingName());
			booking.setServiceSupplierDetails(detachedPOJO.getServiceSupplierDetails());
			booking.setDiscount(detachedPOJO.getDiscount());
			booking.setCustomerId(detachedPOJO.getCustomerId());
			booking.setDateOfBooking(detachedPOJO.getDateOfBooking());
			booking.setTotalAmount(detachedPOJO.getTotalAmount());
			 return  ResponseEntity.accepted().body("Booking updated successfully"); 
		}
		else return ResponseEntity.unprocessableEntity().body("Cannot find the Booking specified");

	}
	@Override
	public ResponseEntity<?> deleteBookingById(int id) {
		Optional<Bookings> c = dao.findById(id);
		if (c.isPresent()) {
			dao.deleteById(id);
			if(c.isPresent()) {
				return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified booking ");	
			}else
			{
			 return ResponseEntity.ok().body("Successfully deleted the specified Booking");
			}
		}else {
			return ResponseEntity.badRequest().body("Cannot find the Booking specified");
		}

	
	}
}
