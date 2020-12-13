package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Cities;
import com.app.pojos.Customers;
import com.app.service.ICityService;
import com.app.service.ICustomerService;

@RestController
public class AdminController {

	@Autowired
	private ICustomerService serviceCustomer;
	@Autowired
	private ICityService serviceCity;

	public AdminController() {
		// TODO Auto-generated constructor stub
		System.out.println("in const admin");
	}
	
	
	// **************************************
	// *************Admin
	// **************************************

	// **************************************
	// *************Customer
	// **************************************
	// API endpoint or providers
	@GetMapping("/admin/customers")

	public ResponseEntity<?> listAllCustomers() {
		List<Customers> allCustomers = serviceCustomer.getAllCustomers();

		if (allCustomers.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allCustomers);
	}

	// **************************************
	// *************City
	// **************************************

	@GetMapping("/admin/cities")
	public ResponseEntity<?> listAllCities() {
		List<Cities> allCities = serviceCity.getAllCities();
		if (allCities.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(allCities);
	}
	
	
	
	// **************************************
	// *************Supplier
	// **************************************

	// **************************************
	// *************Service
	// **************************************

	// **************************************
	// *************Supplier-service
	// **************************************

	// **************************************
	// *************Venue
	// **************************************

	// **************************************
	// *************Facility
	// **************************************

	// **************************************
	// *************Venue-Facilities
	// **************************************

	// **************************************
	// *************Booking
	// **************************************

	// **************************************
	// *************Booking_venue_facilities
	// **************************************

	// **************************************
	// *************booking_service_suppliers
	// **************************************

	
	
}
