package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Bookings;
import com.app.pojos.Customers;
import com.app.pojos.SupplierServices;
import com.app.pojos.Suppliers;
import com.app.pojos.VenueFacilities;
import com.app.pojos.Venues;
import com.app.service.IBookingService;
import com.app.service.ICustomerService;
import com.app.service.ISupplierService;
import com.app.service.ISupplierServicesService;
import com.app.service.IVenueFacilityService;
import com.app.service.IVenueService;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CustomerController {

	public CustomerController() {
		// TODO Auto-generated constructor stub
		System.out.println("in customer constr");
	}

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private IVenueService venueService;
	@Autowired
	private IBookingService bookingService;
	@Autowired
	private IVenueFacilityService venueFacilityService;
	@Autowired
	private ISupplierServicesService supplier_ServiceService;

	@GetMapping("/{customerId}")
	public ResponseEntity<?> getCustomer(@PathVariable int customerId) {
		return customerService.getCustomer(customerId);
	}

	@PutMapping("{customerId}")
	public ResponseEntity<?> updateCustomerDetails(@PathVariable int customerId, @RequestBody Customers c) {
		return customerService.updateCustomerDetails(customerId, c);
	}
	@PostMapping("/create")
	public ResponseEntity<?> addCustomerDeatils(@RequestBody Customers c) {
		return customerService.addCustomerDetails(c);
	}
	
	@GetMapping("/suppliers")
	public ResponseEntity<?> listAllSuppliers() {
		List<Suppliers> allSuppliers = supplierService.getAllSuppliers();
		if (allSuppliers.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(allSuppliers);
	}

	@GetMapping("/supplierService")
	public ResponseEntity<?> listAllSupplierServices() {
		List<SupplierServices> allSupplierServices = supplier_ServiceService.getAllSupplierServices();

		if (allSupplierServices.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allSupplierServices);
	}

	@GetMapping("/venues")
	public ResponseEntity<?> listAllVenues() {
		List<Venues> allVenues = venueService.getAllVenues();
		if (allVenues.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(allVenues);
	}

	@GetMapping("/venueFacilities")
	public ResponseEntity<?> listAllVenueFacilities() {
		List<VenueFacilities> AllVFacilities = venueFacilityService.getAllVenueFacilities();
		if (AllVFacilities.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(AllVFacilities);
	}

	@GetMapping("/bookings")
	public ResponseEntity<?> listAllBooking() {
		List<Bookings> AllBookings = bookingService.getAllBookings();
		if (AllBookings.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(AllBookings);
	}

	@GetMapping("/bookings/{bookingId}")
	public ResponseEntity<?> getBookingDetail(@PathVariable int bookingId) {
		Optional<Bookings> b=Optional.of((bookingService.getBooking(bookingId)));
		if(b.isPresent()) {
		return ResponseEntity.ok(b);
		}
		return	ResponseEntity.badRequest().body("Cannot find the specified Booking");
	}
	@DeleteMapping("/bookings/{bookingId}")
	public ResponseEntity<?> deleteBooking(@PathVariable("bookingId") int id) {
		return bookingService.deleteBookingById(id);
	}

}
