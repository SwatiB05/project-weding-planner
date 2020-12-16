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

import com.app.pojos.Bookings;
import com.app.pojos.Cities;
import com.app.pojos.Customers;
import com.app.pojos.Facilities;
import com.app.pojos.Services;
import com.app.pojos.Supplier_Services;
import com.app.pojos.Suppliers;
import com.app.pojos.Venue_Facilities;
import com.app.pojos.Venues;
import com.app.service.IBookingService;
import com.app.service.ICityService;
import com.app.service.ICustomerService;
import com.app.service.IFacilitesService;
import com.app.service.IServiceService;
import com.app.service.ISupplierService;
import com.app.service.ISupplier_ServiceService;
import com.app.service.IVenueFacilityService;
import com.app.service.IVenueService;

@RestController
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
	private ISupplier_ServiceService supplier_ServiceService;
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
	@GetMapping("/admin/suppliers")

	public ResponseEntity<?> listAllSuppliers() {
		List<Suppliers> allSuppliers = supplierService.getAllSuppliers();

		if (allSuppliers.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allSuppliers);
	}

	/*
	 * @PostMapping("/admin/suppliers/create") public ResponseEntity<?>
	 * addSupplierDetails(@RequestBody Suppliers s) { try { Suppliers supplier =
	 * supplierService.addSupplierDetails(s); return ResponseEntity.ok(supplier);
	 * }catch (Exception e) { e.printStackTrace(); return
	 * ResponseEntity.badRequest().build(); }
	 * 
	 * }
	 */
	
	/*
	 * @PutMapping("/admin/suppliers/{supplierId}") public ResponseEntity<?>
	 * updateSupplierDetails(@PathVariable int supplierId,@RequestBody Suppliers s){
	 * try { Suppliers
	 * updateSupplier=supplierService.updateSupplierDetails(supplierId, s); return
	 * ResponseEntity.ok(updateSupplier); } catch (RuntimeException e) {
	 * e.printStackTrace(); return ResponseEntity.notFound().build(); } }
	 */
	
	
	@DeleteMapping("/admin/suppliers/{supplierId}")
	
	public ResponseEntity<?> deleteSupplier(@PathVariable("supplierId") int id) {
		try {
			supplierService.deleteSupplierById(id);
			return  ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}
	// **************************************
	// *************Service
	// **************************************
	@GetMapping("/admin/service")

	public ResponseEntity<?> listAllServices() {
		List<Services> allServices = serviceService.getAllServices();

		if (allServices.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allServices);
	}
	// **************************************
	// *************Supplier-service
	// **************************************
	@GetMapping("/admin/supplierService")

	public ResponseEntity<?> listAllSupplierServices() {
		List<Supplier_Services> allSupplierServices = supplier_ServiceService.getAllSupplierServices();

		if (allSupplierServices.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allSupplierServices);
	}
	// **************************************
	// *************Venue
	// **************************************
	@GetMapping("/admin/venues")

	public ResponseEntity<?> listAllVenues() {
		List<Venues> allVenues = venueService.getAllVenues();

		if (allVenues.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allVenues);
	}

	@PostMapping("/admin/venues/create")
	public ResponseEntity<?> addVenueDetails(@RequestBody Venues v) {
		try {
			Venues venue = venueService.addVenueDetails(v);
			return ResponseEntity.ok(venue);
		}catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/admin/venues/{venueId}")
	public ResponseEntity<?> updateVenueDetails(@PathVariable int venueId,@RequestBody Venues v){
		try {
			Venues updateVenue=venueService.updateVenueDetails(venueId, v);
			return ResponseEntity.ok(updateVenue);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/admin/venues/{venueId}")
	
	public ResponseEntity<?> deleteVenue(@PathVariable("venueId") int id) {
		try {
			venueService.deleteVenueById(id);
			return  ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}	
	// **************************************
	// *************Facility
	// **************************************
	@GetMapping("/admin/facilities")

	public ResponseEntity<?> listAllFacilities() {
		List<Facilities> AllFacilities = facilityService.getAllFacilities();

		if (AllFacilities.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(AllFacilities);
	}

	@PostMapping("/admin/facilities/create")
	public ResponseEntity<?> addFacilityDetails(@RequestBody Facilities f) {
		try {
			Facilities facility = facilityService.addFacilityDetails(f);
			return ResponseEntity.ok(facility);
		}catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/admin/facilities/{facilityId}")
	public ResponseEntity<?> updateFacilityDetails(@PathVariable int facilityId,@RequestBody Facilities f){
		try {
			Facilities updateVenue=facilityService.updateFacilityDetails(facilityId, f);
			return ResponseEntity.ok(updateVenue);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/admin/facilities/{facilityId}")
	
	public ResponseEntity<?> deleteFacility(@PathVariable("facilityId") int id) {
		try {
			facilityService.deleteFacilityById(id);
			return  ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}	
	// **************************************
	// *************Venue-Facilities
	// **************************************
	@GetMapping("/admin/venueFacilities")

	public ResponseEntity<?> listAllVenueFacilities() {
		List<Venue_Facilities> AllVFacilities = venueFacilityService.getAllVenueFacilities();

		if (AllVFacilities.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(AllVFacilities);
	}
	
	@DeleteMapping("/admin/venueFacilities/{venueFacilityId}")
	
	public ResponseEntity<?> deleteVFacility(@PathVariable("venueFacilityId") int id) {
		try {
			venueFacilityService.deleteVFacilityById(id);
			return  ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}	
	// **************************************
	// *************Booking
	// **************************************
	@GetMapping("/admin/bookings")

	public ResponseEntity<?> listAllBooking() {
		List<Bookings> AllBookings = bookingService.getAllBookings();

		if (AllBookings.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(AllBookings);
	}

	
	@DeleteMapping("/admin/bookings/{bookingId}")
	
	public ResponseEntity<?> deleteBooking(@PathVariable("bookingId") int id) {
		try {
			bookingService.deleteBookingById(id);
			return  ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}	
	
}
