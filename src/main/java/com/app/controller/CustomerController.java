package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Bookings;
import com.app.pojos.Customers;
import com.app.pojos.Supplier_Services;
import com.app.pojos.Suppliers;
import com.app.pojos.Venue_Facilities;
import com.app.pojos.Venues;
import com.app.service.IBookingService;
import com.app.service.ICustomerService;
import com.app.service.ISupplierService;
import com.app.service.ISupplier_ServiceService;
import com.app.service.IVenueFacilityService;
import com.app.service.IVenueService;

@RestController 
  @RequestMapping("/customers") 
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
	private ISupplier_ServiceService supplier_ServiceService;
	
  
  
  @GetMapping("/{customerId}")
	public ResponseEntity<?> getCustomerDetails(@PathVariable int customerId) {
		
		Optional<Customers> optional = customerService.findById(customerId);
		if (optional.isPresent())
	//		return new ResponseEntity<>(optional.get(), HttpStatus.OK);
			return ResponseEntity.ok(optional.get());
		// invalid id
	
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
  
  @PutMapping("{customerId}")
  public ResponseEntity<?>updateCustomerDetails(@PathVariable int customerId,@RequestBody Customers c){
  try {
	  Customers updateCustomer=customerService.updateCustomerDetails(customerId, c);
  return  ResponseEntity.ok(updateCustomer);
  } catch (RuntimeException e) {
  e.printStackTrace(); return ResponseEntity.notFound().build(); }
  }
  
  
  @GetMapping("/suppliers")
	public ResponseEntity<?> listAllSuppliers() {
		List<Suppliers> allSuppliers = supplierService.getAllSuppliers();

		if (allSuppliers.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allSuppliers);
	}
  
  @GetMapping("/admin/supplierService")

	public ResponseEntity<?> listAllSupplierServices() {
		List<Supplier_Services> allSupplierServices = supplier_ServiceService.getAllSupplierServices();

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
		List<Venue_Facilities> AllVFacilities = venueFacilityService.getAllVenueFacilities();

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
  
  }
 