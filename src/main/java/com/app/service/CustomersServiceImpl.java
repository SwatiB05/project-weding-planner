package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.ResourceNotFoundException;
import com.app.dao.ICustomerDao;
import com.app.pojos.Admin;
import com.app.pojos.Cities;
import com.app.pojos.Customers;

@Service
@Transactional
public class CustomersServiceImpl implements ICustomerService {

	// dependency
	@Autowired
	private ICustomerDao dao;


	@Override
	public List<Customers> getAllCustomers() {
		System.out.println("in customerservice get all");
		return dao.findAll();
	}
	
	@Override
	public ResponseEntity<?> findById(int customerId) {
		Optional<Customers> c = dao.findById(customerId);
		if (c.isPresent()) {
			 return  ResponseEntity.ok(c); 
		}
		else return ResponseEntity.badRequest().body("Cannot find the specified Customer");
	}

	@Override
	public ResponseEntity<?> addCustomerDetails(Customers transientpojo) {
		Optional<Customers> c = dao.findByEmail(transientpojo.getEmail());
		if (c.isPresent()) {
			 return ResponseEntity.badRequest().body("The customer is already Present, Fail to create");
		}
		dao.save(transientpojo);
		return ResponseEntity.ok("Customer Created Successfully");
	}

	@Override
	public ResponseEntity<?> updateCustomerDetails(int customerId, Customers detachedPOJO) {
		Optional<Customers> c = dao.findById(customerId);
		if (c.isPresent()) {
			Customers customer = c.get();
			customer.setCcityId(detachedPOJO.getCcityId());
			customer.setFirstName(detachedPOJO.getFirstName());
			customer.setLastName(detachedPOJO.getLastName());
			customer.setCustomerAddress(detachedPOJO.getCustomerAddress());
			customer.setEmail(detachedPOJO.getEmail());
			customer.setPhoneNo(detachedPOJO.getPhoneNo());
			return ResponseEntity.accepted().body("Customer updated successfully"); 
		}
		else return ResponseEntity.badRequest().body("Cannot find the specified Cusstomer");

	}

	@Override
	public ResponseEntity<?> deleteCustomerById(int customerId) {
		Optional<Customers> c = dao.findById(customerId);
		if (c.isPresent()) {
			dao.deleteById(customerId);
			if(c.isPresent()) {
				return ResponseEntity.badRequest().body("Failed to Delete the specified City it is associated with Booking");	
			}else
			{
			 return ResponseEntity.ok().body("Successfully deleted the specified Customer");
			}
		}else {
			return ResponseEntity.badRequest().body("Cannot find the specified Customer");
		}
	}

	
	@Override
	public ResponseEntity<?> adminAuthentication(String email, String password) {
		Optional<Customers> admin = dao.findByEmail(email);
		if(admin.isPresent()) {
			if(admin.get().getPassword()==password) {
				return ResponseEntity.ok("Login Sucessfull");
			}
			return ResponseEntity.badRequest().body("Wrong PassWord");
		}
		return ResponseEntity.badRequest().body("Invalid Credentials...");
	}

	

	

}
