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

import com.app.pojos.Bookings;
import com.app.pojos.Cities;
import com.app.pojos.Customers;
import com.app.pojos.Facilities;
import com.app.pojos.Services;
import com.app.pojos.SupplierServices;
import com.app.pojos.Suppliers;
import com.app.pojos.VenueFacilities;
import com.app.pojos.Venues;
import com.app.service.IBookingService;
import com.app.service.ICityService;
import com.app.service.ICustomerService;
import com.app.service.IFacilitesService;
import com.app.service.IServiceService;
import com.app.service.ISupplierService;
import com.app.service.ISupplierServicesService;
import com.app.service.IVenueFacilityService;
import com.app.service.IVenueService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

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

	@PostMapping("/cities/create")
	public ResponseEntity<?> addCityDeatils(@RequestBody Cities c) {
<<<<<<< HEAD
		return cityService.addCityDetails(c);
=======
	return cityService.addCityDetails(c);
>>>>>>> bc7bf36ab920bc640b138d28ff60915c348694b3
	}

	@PutMapping("/cities/{cityId}")
	public ResponseEntity<?> updateCityDetails(@PathVariable int cityId, @RequestBody Cities c) {
		return cityService.updateCityDetails(cityId, c);
	}

	@DeleteMapping("/cities/{cityId}")

	public ResponseEntity<?> deleteCity(@PathVariable("cityId") int id) {
<<<<<<< HEAD
		return cityService.deleteCityById(id);
=======
		
		return	cityService.deleteCityById(id);
			

>>>>>>> bc7bf36ab920bc640b138d28ff60915c348694b3
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

<<<<<<< HEAD
	// for testing
	@PostMapping("/suppliers/create")
	public ResponseEntity<?> addSupplierDetails(@RequestBody Suppliers s) {
		try {
			Suppliers supplier = supplierService.addSupplierDetails(s);
			return ResponseEntity.ok(supplier);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

	// for testing
	@PutMapping("/suppliers/{supplierId}")
	public ResponseEntity<?> updateSupplierDetails(@PathVariable int supplierId, @RequestBody Suppliers s) {
		try {
			Suppliers updateSupplier = supplierService.updateSupplierDetails(supplierId, s);
			return ResponseEntity.ok(updateSupplier);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
=======
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
	 
>>>>>>> bc7bf36ab920bc640b138d28ff60915c348694b3

	@DeleteMapping("/suppliers/{supplierId}")

	public ResponseEntity<?> deleteSupplier(@PathVariable("supplierId") int id) {
<<<<<<< HEAD
		try {
			supplierService.deleteSupplierById(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			// return new ResponseEntity<>(new ResponseDTO("There are Bookings associated
			// with This Supplier"), HttpStatus.BAD_REQUEST);
			return ResponseEntity.badRequest().build();
		}
=======
		return supplierService.deleteSupplierById(id);
>>>>>>> bc7bf36ab920bc640b138d28ff60915c348694b3

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

	// for testing
	@PostMapping("/services/create")
	public ResponseEntity<?> addServiceDetails(@RequestBody Services s) {
		return serviceService.addServiceDetails(s);
	}

	// for testing
	@PutMapping("/services/{serviceId}")
	public ResponseEntity<?> updateServiceDetails(@PathVariable int serviceId, @RequestBody Services v) {
		return serviceService.updateServiceDetails(serviceId, v);
	}

	// for testing
	@DeleteMapping("/services/{serviceId}")

	public ResponseEntity<?> deleteService(@PathVariable("serviceId") int id) {
<<<<<<< HEAD
		try {
			serviceService.deleteServiceById(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
			// return new ResponseEntity<>(new ResponseDTO("There are Bookings associated
			// with This service"), HttpStatus.BAD_REQUEST);
		}

=======
		return serviceService.deleteServiceById(id);
>>>>>>> bc7bf36ab920bc640b138d28ff60915c348694b3
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
<<<<<<< HEAD
	public ResponseEntity<?> updateSupplierService(@PathVariable int supplierServiceId,
			@RequestBody SupplierServices v) {
		try {
			SupplierServices updateVenue = supplier_ServiceService.updateSupplierServiceDetails(supplierServiceId, v);
			return ResponseEntity.ok(updateVenue);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
=======
	public ResponseEntity<?> updateSupplierService(@PathVariable int supplierServiceId, @RequestBody SupplierServices v) {
		return supplier_ServiceService.updateSupplierServiceDetails(supplierServiceId, v);
>>>>>>> bc7bf36ab920bc640b138d28ff60915c348694b3
	}

	// for testing
	@DeleteMapping("/supplierService/{supplierServiceId}")
	public ResponseEntity<?> deleteSupplierServiceById(@PathVariable("supplierServiceId") int id) {
<<<<<<< HEAD
		try {
			supplier_ServiceService.deleteSupplierServiceById(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
			// return new ResponseEntity<>(new ResponseDTO("There are Bookings associated
			// with This SupplierService"), HttpStatus.BAD_REQUEST);
		}
=======
		return supplier_ServiceService.deleteSupplierServiceById(id);
>>>>>>> bc7bf36ab920bc640b138d28ff60915c348694b3

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
<<<<<<< HEAD
		try {
			venueService.deleteVenueById(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
			// return new ResponseEntity<>(new ResponseDTO("There are Bookings associated
			// with This Venue"), HttpStatus.BAD_REQUEST);
		}
=======
		return venueService.deleteVenueById(id);
>>>>>>> bc7bf36ab920bc640b138d28ff60915c348694b3

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
<<<<<<< HEAD
	public ResponseEntity<?> updateVenueFacilityDetails(@PathVariable int venueFacilitiesId,
			@RequestBody VenueFacilities v) {
		try {
			VenueFacilities updateVenue = venueFacilityService.updateVenueFacilityDetails(venueFacilitiesId, v);
			return ResponseEntity.ok(updateVenue);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
=======
	public ResponseEntity<?> updateVenueFacilityDetails(@PathVariable int venueFacilitiesId, @RequestBody VenueFacilities v) {
		return venueFacilityService.updateVenueFacilityDetails(venueFacilitiesId, v);
>>>>>>> bc7bf36ab920bc640b138d28ff60915c348694b3
	}

	@DeleteMapping("/venueFacilities/{venueFacilityId}")
	public ResponseEntity<?> deleteVFacility(@PathVariable("venueFacilityId") int id) {
<<<<<<< HEAD
		try {
			venueFacilityService.deleteVenueFacilityById(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
			// return new ResponseEntity<>(new ResponseDTO("There are Booking associated
			// with This venueFacility"), HttpStatus.BAD_REQUEST);
		}
=======
		return venueFacilityService.deleteVenueFacilityById(id);
>>>>>>> bc7bf36ab920bc640b138d28ff60915c348694b3
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
