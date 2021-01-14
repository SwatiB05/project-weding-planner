package com.app.controller;

import java.util.List;

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

import com.app.pojos.Admin;
import com.app.pojos.Bookings;
import com.app.pojos.Cities;
import com.app.pojos.Customers;
import com.app.pojos.Facilities;
import com.app.pojos.Services;
import com.app.pojos.SupplierServices;
import com.app.pojos.Suppliers;
import com.app.pojos.VenueFacilities;
import com.app.pojos.Venues;
import com.app.service.IAdminService;
import com.app.service.IBookingService;
import com.app.service.ICityService;
import com.app.service.ICustomerService;
import com.app.service.IFacilitesService;
import com.app.service.IServiceService;
import com.app.service.ISupplierService;
import com.app.service.ISupplierServicesService;
import com.app.service.IVenueFacilityService;
import com.app.service.IVenueService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private ICityService cityService;
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private IVenueService venueService;
	@Autowired
	private IFacilitesService facilityService;
	@Autowired
	private IBookingService bookingService;
	@Autowired
	private IVenueFacilityService venueFacilityService;
	@Autowired
	private ISupplierServicesService supplier_ServiceService;
	@Autowired
	private IServiceService serviceService;

	public AdminController() {
		// TODO Auto-generated constructor stub
		System.out.println("in const admin");
	}

	// **************************************
	// *************Admin
	// **************************************
@PostMapping("/login")
public ResponseEntity<?> adminauthenticate(@RequestBody String details) {
	Admin u = null;
	try {
		 u = new ObjectMapper().readValue(details, Admin.class);
		 System.out.println("name  "+u.getEmail()+" password  "+u.getPassword());
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return adminService.adminAuthentication(u.getEmail(), u.getPassword());
	
}
	// **************************************
	// *************Customer
	// **************************************
	// API end point or providers

	@GetMapping("/customers")
	public ResponseEntity<?> listAllCustomers() {
		List<Customers> allCustomers = customerService.getAllCustomers();
		if (allCustomers.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(allCustomers);
	}

	@PostMapping("/customers/create")
	public ResponseEntity<?> addCustomerDeatils(@RequestBody Customers c) {
		return customerService.addCustomerDetails(c);
	}

	@PutMapping("/customers/{customerId}")
	public ResponseEntity<?> updateCustomerDetails(@PathVariable int customerId, @RequestBody Customers c) {
		return customerService.updateCustomerDetails(customerId, c);
	}

	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) {
		return customerService.deleteCustomerById(customerId);

	}

	// **************************************
	// *************City
	// **************************************

	@GetMapping("/cities")
	public ResponseEntity<?> listAllCities() {
		List<Cities> allCities = cityService.getAllCities();
		if (allCities.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(allCities);
	}
	
	@GetMapping("/cities/{cityId}")
	public ResponseEntity<?> getCity(@PathVariable("cityId") int id) {
		return cityService.findById(id);
	}

	@PostMapping("/cities/create")
	public ResponseEntity<?> addCityDeatils(@RequestBody Cities c) {
		return cityService.addCityDetails(c);
	}

	@PutMapping("/cities/{cityId}")
	public ResponseEntity<?> updateCityDetails(@PathVariable int cityId, @RequestBody Cities c) {
		return cityService.updateCityDetails(cityId, c);
	}

	@DeleteMapping("/cities/{cityId}")
	public ResponseEntity<?> deleteCity(@PathVariable("cityId") int id) {
		return cityService.deleteCityById(id);
	}

	// **************************************
	// *************Supplier
	// **************************************
	@GetMapping("/suppliers")

	public ResponseEntity<?> listAllSuppliers() {
		List<Suppliers> allSuppliers = supplierService.getAllSuppliers();

		if (allSuppliers.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allSuppliers);
	}


	//for testing
	  @PostMapping("/suppliers/create")
	  public ResponseEntity<?>addSupplierDetails(@RequestBody Suppliers s) { 
		 return supplierService.addSupplierDetails(s);
	  }
	  
	  
	  //for testing
	  @PutMapping("/suppliers/{supplierId}")
	  public ResponseEntity<?>updateSupplierDetails(@PathVariable int supplierId,@RequestBody Suppliers s){
	 return supplierService.updateSupplierDetails(supplierId, s);
	  }


	@DeleteMapping("/suppliers/{supplierId}")

	public ResponseEntity<?> deleteSupplier(@PathVariable("supplierId") int id) {
		return supplierService.deleteSupplierById(id);
	}

	// **************************************
	// *************Service
	// **************************************
	@GetMapping("/services")

	public ResponseEntity<?> listAllServices() {
		List<Services> allServices = serviceService.getAllServices();
		if (allServices.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(allServices);
	}
	
	@GetMapping("/services/{serviceId}")
	public ResponseEntity<?> getService(@PathVariable("serviceId") int id) {
		return serviceService.findById(id);
	}

	// for testing
	@PostMapping("/services/create")
	public ResponseEntity<?> addServiceDetails(@RequestBody Services s) {
		return serviceService.addServiceDetails(s);
	}

	// for testing
	@PutMapping("/services/{service}")
	public ResponseEntity<?> updateServiceDetails(@PathVariable int service, @RequestBody Services v) {
		return serviceService.updateServiceDetails(service, v);
	}

	// for testing
	@DeleteMapping("/services/{serviceId}")
	public ResponseEntity<?> deleteService(@PathVariable("serviceId") int id) {
		return serviceService.deleteServiceById(id);

	}

	// **************************************
	// *************Supplier-service
	// **************************************
	@GetMapping("/supplierService")

	public ResponseEntity<?> listAllSupplierServices() {
		List<SupplierServices> allSupplierServices = supplier_ServiceService.getAllSupplierServices();

		if (allSupplierServices.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allSupplierServices);
	}

	// for testing
	@PostMapping("/supplierService/create")
	public ResponseEntity<?> addSupplierServiceDetails(@RequestBody SupplierServices v) {
		return supplier_ServiceService.addSupplierServiceDetails(v);
	}

	// for testing
	@PutMapping("/supplierService/{supplierServiceId}")
	public ResponseEntity<?> updateSupplierService(@PathVariable int supplierServiceId, @RequestBody SupplierServices v) {
		return supplier_ServiceService.updateSupplierServiceDetails(supplierServiceId, v);

	}

	// for testing
	@DeleteMapping("/supplierService/{supplierServiceId}")
	public ResponseEntity<?> deleteSupplierServiceById(@PathVariable("supplierServiceId") int id) {
		return supplier_ServiceService.deleteSupplierServiceById(id);
	}

	// **************************************
	// *************Venue
	// **************************************
	@GetMapping("/venues")

	public ResponseEntity<?> listAllVenues() {
		List<Venues> allVenues = venueService.getAllVenues();

		if (allVenues.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allVenues);
	}
	
	@GetMapping("/venues/{venueId}")
	public ResponseEntity<?> findById(@PathVariable("venueId") int id) {
		return venueService.findById(id);
	}
	

	@PostMapping("/venues/create")
	public ResponseEntity<?> addVenueDetails(@RequestBody Venues v) {
		return venueService.addVenueDetails(v);

	}

	@PutMapping("/venues/{venueId}")
	public ResponseEntity<?> updateVenueDetails(@PathVariable int venueId, @RequestBody Venues v) {
		return venueService.updateVenueDetails(venueId, v);
	}

	@DeleteMapping("/venues/{venueId}")

	public ResponseEntity<?> deleteVenue(@PathVariable("venueId") int id) {
		return venueService.deleteVenueById(id);
	}

	// **************************************
	// *************Facility
	// **************************************
	@GetMapping("/facilities")

	public ResponseEntity<?> listAllFacilities() {
		List<Facilities> AllFacilities = facilityService.getAllFacilities();
		if (AllFacilities.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(AllFacilities);
	}
	
	@GetMapping("/facilities/{facilityId}")
	public ResponseEntity<?> getFacility(@PathVariable("facilityId") int id) {
		return facilityService.findById(id);
	}

	@PostMapping("/facilities/create")
	public ResponseEntity<?> addFacilityDetails(@RequestBody Facilities f) {
		return facilityService.addFacilityDetails(f);
	}

	@PutMapping("/facilities/{facilityId}")
	public ResponseEntity<?> updateFacilityDetails(@PathVariable int facilityId, @RequestBody Facilities f) {
		return facilityService.updateFacilityDetails(facilityId, f);
	}

	
	
	@DeleteMapping("/facilities/{facilityId}")

	public ResponseEntity<?> deleteFacility(@PathVariable("facilityId") int id) {
		return facilityService.deleteFacilityById(id);
	}

	// **************************************
	// *************Venue-Facilities
	// **************************************
	@GetMapping("/venueFacilities")

	public ResponseEntity<?> listAllVenueFacilities() {
		List<VenueFacilities> AllVFacilities = venueFacilityService.getAllVenueFacilities();

		if (AllVFacilities.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(AllVFacilities);
	}

	// for testing
	@PostMapping("/venueFacilities/create")
	public ResponseEntity<?> addVenueFacilityDetails(@RequestBody VenueFacilities v) {
		return venueFacilityService.addVenueFacilityDetails(v);

	}

	// for testing
	@PutMapping("/venueFacilities/{venueFacilitiesId}")
	public ResponseEntity<?> updateVenueFacilityDetails(@PathVariable int venueFacilitiesId, @RequestBody VenueFacilities v) {
		return venueFacilityService.updateVenueFacilityDetails(venueFacilitiesId, v);
	}

	@DeleteMapping("/venueFacilities/{venueFacilityId}")
	public ResponseEntity<?> deleteVFacility(@PathVariable("venueFacilityId") int id) {
		return venueFacilityService.deleteVenueFacilityById(id);

	}

	// **************************************
	// *************Booking
	// **************************************
	@GetMapping("/bookings")
	public ResponseEntity<?> listAllBooking() {
		List<Bookings> AllBookings = bookingService.getAllBookings();
		if (AllBookings.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(AllBookings);
	}

	// for testing
	@PostMapping("/bookings/create")
	public ResponseEntity<?> addBookingDetails(@RequestBody Bookings v) {
		return bookingService.addBookingDetails(v);
	}

	// for testing
	@PutMapping("/bookings/{bookingId}")
	public ResponseEntity<?> updateBookingDetails(@PathVariable int bookingId, @RequestBody Bookings v) {
		return bookingService.updateBookingDetails(bookingId, v);
	}

	@DeleteMapping("/bookings/{bookingId}")
	public ResponseEntity<?> deleteBooking(@PathVariable("bookingId") int id) {
		return bookingService.deleteBookingById(id);
	}

}
