package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Cities;
import com.app.pojos.Customers;
import com.app.service.ICityService;
import com.app.service.ICustomerService;

@RestController
public class AdminController {

	@Autowired
	private ICustomerService customerService;
	@Autowired
	private ICityService cityService;
	


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
		List<Customers> allCustomers = customerService.getAllCustomers();

		if (allCustomers.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allCustomers);
	}

	@PostMapping("/admin/customers/create")
	public ResponseEntity<?> addCustomerDeatils(@RequestBody Customers c) {
		try {
			Customers customer = customerService.addCustomerDetails(c);
			return ResponseEntity.ok(customer);
		}catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/admin/customers/{customerId}")
	public ResponseEntity<?> updateCustomerDetails(@PathVariable int customerId,@RequestBody Customers c){
		try {
			Customers updateCustomer=customerService.updateCustomerDetails(customerId, c);
			return ResponseEntity.ok(updateCustomer);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/admin/customers/{customerId}")
	
	public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") int id) {
		try {
			customerService.deleteCustomerById(id);
			return  ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}
	
	// **************************************
	// *************City
	// **************************************

	@GetMapping("/admin/cities")
	public ResponseEntity<?> listAllCities() {
		List<Cities> allCities = cityService.getAllCities();
		if (allCities.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(allCities);
	}
	
	@PostMapping("/admin/cities/create")
	public ResponseEntity<?> addCityDeatils(@RequestBody Cities c) {
		try {
			Cities city = cityService.addCityDetails(c);
			return ResponseEntity.ok(city);
		}catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/admin/cities/{cityId}")
	public ResponseEntity<?> updateCityDetails(@PathVariable int cityId,@RequestBody Cities c){
		try {
			Cities updateCity=cityService.updateCityDetails(cityId, c);
			return ResponseEntity.ok(updateCity);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/admin/cities/{cityId}")
	
	public ResponseEntity<?> deleteCity(@PathVariable("cityId") int id) {
		try {
			cityService.deleteCityById(id);
			return  ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

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
