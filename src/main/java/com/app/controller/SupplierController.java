package com.app.controller;

import java.util.List;
import java.util.Optional;

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

import com.app.pojos.Bookings;
import com.app.pojos.Services;
import com.app.pojos.Suppliers;
import com.app.pojos.Venues;
import com.app.service.IBookingService;
import com.app.service.IServiceService;
import com.app.service.ISupplierService;
import com.app.service.IVenueService;

@RestController 
@RequestMapping("/suppliers") 
@CrossOrigin(origins = "http://localhost:4200")
public class SupplierController {

	public SupplierController() {
		// TODO Auto-generated constructor stub
		System.out.println("in supplier constr");
	}
	
	
	@Autowired
	private IBookingService bookingService;
	@Autowired
	private IServiceService serviceService;
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private IVenueService venueService;
	
	
	@GetMapping("{supplierId}")
public ResponseEntity<?> getSupplierDetails(@PathVariable int supplierId) {
		
		Optional<Suppliers> optional = supplierService.findById(supplierId);
		if (optional.isPresent())
	//		return new ResponseEntity<>(optional.get(), HttpStatus.OK);
			return ResponseEntity.ok(optional.get());
		// invalid id
	
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	  
	  
	  @PutMapping("/{supplierId}")
	  public ResponseEntity<?>updateSupplierDetails(@PathVariable int supplierId,@RequestBody Suppliers s){
	  return supplierService.updateSupplierDetails(supplierId, s);
	  }
	 
	
	@GetMapping("/services")
	public ResponseEntity<?> listAllServices() {
		List<Services> allServices = serviceService.getAllServices();

		if (allServices.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allServices);
	}
	
	@PostMapping("/services/create")
	public ResponseEntity<?> addServiceDetails(@RequestBody Services s) {
		return serviceService.addServiceDetails(s);
	}

	
	@PutMapping("/services/{service}")
	public ResponseEntity<?> updateServiceDetails(@PathVariable String service, @RequestBody Services v) {
		return serviceService.updateServiceDetails(service, v);
	}

	
	@DeleteMapping("/services/{serviceId}")
	public ResponseEntity<?> deleteService(@PathVariable("serviceId") int id) {
		return serviceService.deleteServiceById(id);
	}
	
	@GetMapping("/venues")
	public ResponseEntity<?> listAllVenues() {
		List<Venues> allVenues = venueService.getAllVenues();

		if (allVenues.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(allVenues);
	}

	
	@GetMapping("/bookings")
	public ResponseEntity<?> listAllBooking() {
		List<Bookings> AllBookings = bookingService.getAllBookings();

		if (AllBookings.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(AllBookings);
	}

}
