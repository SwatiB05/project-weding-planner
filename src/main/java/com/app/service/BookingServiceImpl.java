package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.ResourceNotFoundException;
import com.app.dao.IBookingDao;
import com.app.pojos.Bookings;
@Service
@Transactional
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingDao dao;
	@Override
	public List<Bookings> getAllBookings() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	

	@Override
	public void deleteBookingById(int id) {
		// TODO Auto-generated method stub
      dao.deleteById(id);;
	}

	@Override
	public Bookings addBookingDetails(Bookings b) {
		// TODO Auto-generated method stub
		return dao.save(b);
	}

	@Override
	public Bookings updateBookingDetails(int bookingId, Bookings detachedPOJO) {
		Optional<Bookings> c = dao.findById(bookingId);
		if (c.isPresent()) {
			// c.get() : PERSISTENT
			// cityDetachPojo : detached POJO : contains the updates sent by clnt
			// change state of persistent POJO
			Bookings booking = c.get();
			booking.setVenueFacilityDetails(detachedPOJO.getVenueFacilityDetails());
			booking.setBookingName(detachedPOJO.getBookingName());
			booking.setServiceSupplierDetails(detachedPOJO.getServiceSupplierDetails());
			booking.setDiscount(detachedPOJO.getDiscount());
			booking.setCustomerId(detachedPOJO.getCustomerId());
			booking.setDateOfBooking(detachedPOJO.getDateOfBooking());
			booking.setTotalAmount(detachedPOJO.getTotalAmount());
			return booking;

		}
		// in case of no product found : throw custom exception
		throw new ResourceNotFoundException("Invalid Customer ID");

	}

}
