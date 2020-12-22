package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.app.dto.ResponseDTO;
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
@RequestMapping("/admin")
@CrossOrigin(origins = "*",allowedHeaders = "*")
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

	@GetMapping("/customers")

	public ResponseEntity<?> listAllCustomers() {
		List<Customers> allCustomers = customerService.getAllCustomers();

		if (allCustomers.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(allCustomers);
	}

	@PostMapping("/customers/create")
	public ResponseEntity<?> addCustomerDeatils(@RequestBody Customers c) {
		try {
			Customers customer = customerService.addCustomerDetails(c);
			return ResponseEntity.ok(customer);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}

	@PutMapping("/customers/{customerId}")
	public ResponseEntity<?> updateCustomerDetails(@PathVariable int customerId, @RequestBody Customers c) {
		try {
			Customers updateCustomer = customerService.updateCustomerDetails(customerId, c);
			return ResponseEntity.ok(updateCustomer);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) {
		try {
			customerService.deleteCustomerById(customerId);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ResponseDTO("There are Bookings associated with This Customer"), HttpStatus.BAD_REQUEST);
			//return ResponseEntity.badRequest().build();
		}

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
		try {
			Cities city = cityService.addCityDetails(c);
			return ResponseEntity.ok(city);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}

	@PutMapping("/cities/{cityId}")
	public ResponseEntity<?> updateCityDetails(@PathVariable int cityId, @RequestBody Cities c) {
		try {
			Cities updateCity = cityService.updateCityDetails(cityId, c);
			return ResponseEntity.ok(updateCity);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/cities/{cityId}")

	public ResponseEntity<?> deleteCity(@PathVariable("cityId") int id) {
		try {
			cityService.deleteCityById(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ResponseDTO("There are Customers associated with this City"), HttpStatus.BAD_REQUEST);
			//return ResponseEntity.badRequest().build();
		}

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
		  try { Suppliers supplier =supplierService.addSupplierDetails(s);
		  return ResponseEntity.ok(supplier);
	  }catch (RuntimeException e) { 
		  e.printStackTrace();
		  return ResponseEntity.badRequest().build(); 
		  } 
	  }
	  
	  
	  //for testing
	  @PutMapping("/suppliers/{supplierId}")
	  public ResponseEntity<?>updateSupplierDetails(@PathVariable int supplierId,@RequestBody Suppliers s){
	  try { Suppliers updateSupplier=supplierService.updateSupplierDetails(supplierId, s);
	  return  ResponseEntity.ok(updateSupplier);
	  } catch (RuntimeException e) {
	  e.printStackTrace(); return ResponseEntity.notFound().build(); }
	  }
	 

	@DeleteMapping("/suppliers/{supplierId}")

	public ResponseEntity<?> deleteSupplier(@PathVariable("supplierId") int id) {
		try {
			supplierService.deleteSupplierById(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ResponseDTO("There are Bookings associated with This Supplier"), HttpStatus.BAD_REQUEST);
			//return ResponseEntity.badRequest().build();
		}

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
	
	//for testing
	@PostMapping("/services/create")
	public ResponseEntity<?> addServiceDetails(@RequestBody Services s) {
		try {
			Services services = serviceService.addServiceDetails(s);
			return ResponseEntity.ok(services);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}

	//for testing
	@PutMapping("/services/{serviceId}")
	public ResponseEntity<?> updateServiceDetails(@PathVariable int serviceId, @RequestBody Services v) {
		try {
			Services updateService = serviceService.updateServiceDetails(serviceId, v);
			return ResponseEntity.ok(updateService);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}

	//for testing
	@DeleteMapping("/services/{serviceId}")

	public ResponseEntity<?> deleteService(@PathVariable("serviceId") int id) {
		try {
			serviceService.deleteServiceById(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			//return ResponseEntity.badRequest().build();
			return new ResponseEntity<>(new ResponseDTO("There are Bookings associated with This service"), HttpStatus.BAD_REQUEST);
		}

	}

	// **************************************
	// *************Supplier-service
	// **************************************
	@GetMapping("/supplierService")

	public ResponseEntity<?> listAllSupplierServices() {
		List<Supplier_Services> allSupplierServices = supplier_ServiceService.getAllSupplierServices();

		if (allSupplierServices.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allSupplierServices);
	}

	//for testing
	@PostMapping("/supplierService/create")
	public ResponseEntity<?> addSupplierServiceDetails(@RequestBody Supplier_Services v) {
		try {
			Supplier_Services service = supplier_ServiceService.addSupplierServiceDetails(v);
			return ResponseEntity.ok(service);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}

	//for testing
	@PutMapping("/supplierService/{supplierServiceId}")
	public ResponseEntity<?> updateSupplierService(@PathVariable int supplierServiceId, @RequestBody Supplier_Services v) {
		try {
			Supplier_Services updateVenue = supplier_ServiceService.updateSupplierServiceDetails(supplierServiceId, v);
			return ResponseEntity.ok(updateVenue);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}

	//for testing
	@DeleteMapping("/supplierService/{supplierServiceId}")
	public ResponseEntity<?> deleteSupplierServiceById(@PathVariable("supplierServiceId") int id) {
		try {
			supplier_ServiceService.deleteSupplierServiceById(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			//return ResponseEntity.badRequest().build();
			return new ResponseEntity<>(new ResponseDTO("There are Bookings associated with This SupplierService"), HttpStatus.BAD_REQUEST);
		}

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
		try {
			Venues venue = venueService.addVenueDetails(v);
			return ResponseEntity.ok(venue);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}

	@PutMapping("/venues/{venueId}")
	public ResponseEntity<?> updateVenueDetails(@PathVariable int venueId, @RequestBody Venues v) {
		try {
			Venues updateVenue = venueService.updateVenueDetails(venueId, v);
			return ResponseEntity.ok(updateVenue);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/venues/{venueId}")

	public ResponseEntity<?> deleteVenue(@PathVariable("venueId") int id) {
		try {
			venueService.deleteVenueById(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			//return ResponseEntity.badRequest().build();
			return new ResponseEntity<>(new ResponseDTO("There are Bookings associated with This Venue"), HttpStatus.BAD_REQUEST);
		}

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
		try {
			Facilities facility = facilityService.addFacilityDetails(f);
			return ResponseEntity.ok(facility);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}

	@PutMapping("/facilities/{facilityId}")
	public ResponseEntity<?> updateFacilityDetails(@PathVariable int facilityId, @RequestBody Facilities f) {
		try {
			Facilities updateVenue = facilityService.updateFacilityDetails(facilityId, f);
			return ResponseEntity.ok(updateVenue);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/facilities/{facilityId}")

	public ResponseEntity<?> deleteFacility(@PathVariable("facilityId") int id) {
		try {
			facilityService.deleteFacilityById(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			//return ResponseEntity.badRequest().build();
			return new ResponseEntity<>(new ResponseDTO("There are Venue associated with This facility"), HttpStatus.BAD_REQUEST);
		}
		

	}

	// **************************************
	// *************Venue-Facilities
	// **************************************
	@GetMapping("/venueFacilities")

	public ResponseEntity<?> listAllVenueFacilities() {
		List<Venue_Facilities> AllVFacilities = venueFacilityService.getAllVenueFacilities();

		if (AllVFacilities.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(AllVFacilities);
	}
	
	//for testing
	@PostMapping("/venueFacilities/create")
	public ResponseEntity<?> addVenueFacilityDetails(@RequestBody Venue_Facilities v) {
		try {
			Venue_Facilities venueFacilities = venueFacilityService.addVenueFacilityDetails(v);
			return ResponseEntity.ok(venueFacilities);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}

	//for testing
	@PutMapping("/venueFacilities/{venueFacilitiesId}")
	public ResponseEntity<?> updateVenueFacilityDetails(@PathVariable int venueFacilitiesId, @RequestBody Venue_Facilities v) {
		try {
			Venue_Facilities updateVenue = venueFacilityService.updateVenueFacilityDetails(venueFacilitiesId, v);
			return ResponseEntity.ok(updateVenue);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/venueFacilities/{venueFacilityId}")
	public ResponseEntity<?> deleteVFacility(@PathVariable("venueFacilityId") int id) {
		try {
			venueFacilityService.deleteVFacilityById(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			//return ResponseEntity.badRequest().build();
			return new ResponseEntity<>(new ResponseDTO("There are Booking associated with This venueFacility"), HttpStatus.BAD_REQUEST);
		}
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

	//for testing
	@PostMapping("/bookings/create")
	public ResponseEntity<?> addBookingDetails(@RequestBody Bookings v) {
		try {
			Bookings addBookings = bookingService.addBookingDetails(v);
			return ResponseEntity.ok(addBookings);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}

	//for testing
	@PutMapping("/bookings/{bookingId}")
	public ResponseEntity<?> updateBookingDetails(@PathVariable int bookingId, @RequestBody Bookings v) {
		try {
			Bookings updateBookings = bookingService.updateBookingDetails(bookingId, v);
			return ResponseEntity.ok(updateBookings);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/bookings/{bookingId}")

	public ResponseEntity<?> deleteBooking(@PathVariable("bookingId") int id) {
		try {
			bookingService.deleteBookingById(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

}
