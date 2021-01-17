package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICitiesDao;
import com.app.dao.ICustomerDao;
import com.app.dto.CustomerDTO;
import com.app.dto.SupplierDTO;
import com.app.pojos.Customers;
import com.app.pojos.Suppliers;

@Service
@Transactional
public class CustomersServiceImpl implements ICustomerService {

	// dependency
	@Autowired
	private ICustomerDao dao;
	@Autowired
	private ICitiesDao cityDao;

	
	@Override
	public List<Customers> getAllCustomers() {
		System.out.println("in customerservice get all");
		return dao.findAll();
	}

	@Override
	public ResponseEntity<?> getCustomer(int customerId) {
		Optional<Customers> c = dao.findById(customerId);
		if (c.isPresent()) {
			System.out.println(c);
			return ResponseEntity.ok(new CustomerDTO(c.get()));	
		} else
			return ResponseEntity.badRequest().body("Cannot find the specified Customer");
		}


	@Override
	public ResponseEntity<?> updateCustomerDetails(int customerId, Customers detachedPOJO) {
		Optional<Customers> c = dao.findById(customerId);
		if (c.isPresent()) {
			Customers customer = c.get();
			detachedPOJO.setCcityId(cityDao.getOne(detachedPOJO.getCcityId().getCityId()));
			customer.setCcityId(detachedPOJO.getCcityId());
			customer.setFirstName(detachedPOJO.getFirstName());
			customer.setLastName(detachedPOJO.getLastName());
			customer.setCustomerAddress(detachedPOJO.getCustomerAddress());
			customer.setEmail(detachedPOJO.getEmail());
			customer.setPhoneNo(detachedPOJO.getPhoneNo());
			return ResponseEntity.accepted().body("Customer updated successfully");
		} else
			return ResponseEntity.badRequest().body("Cannot find the specified Cusstomer");

	}

	@Override
	public ResponseEntity<?> deleteCustomerById(int customerId) {
		Optional<Customers> c = dao.findById(customerId);
		if (c.isPresent()) {
			dao.deleteById(customerId);
			return ResponseEntity.ok().body("Successfully deleted the specified Customer");
		} else {
			return ResponseEntity.badRequest().body("Cannot find the Customer specified");
		}
	}

	@Override
	public ResponseEntity<?> customerAuthentication(String email, String password) {
		Optional<Customers> c = dao.findByEmail(email);
		if (c.isPresent()) {
			if (c.get().getPassword().contentEquals(password)) {
				return ResponseEntity.ok(new CustomerDTO(c.get()));
			} else {
				return ResponseEntity.badRequest().body("Wrong PassWord");
			}
		} else {
			return ResponseEntity.badRequest().body("Invalid Credentials...");
		}

	}

	@Override
	public ResponseEntity<?> updateCustomerStatus(int id) {
		Optional<Customers> c = dao.findById(id);
		if (c.isPresent()) {
			int num = c.get().getIsActive().intValue();
			System.out.println(num);
			if (num == 1) {
				int n=0;
				c.get().setIsActive(n);
				System.out.println(c.get().getIsActive().intValue());
				return ResponseEntity.ok().body("suspend Customer");
			} else {
				int n=1;
				c.get().setIsActive(n);
				System.out.println(c.get().getIsActive().intValue());
				return ResponseEntity.ok().body("Activate Customer");
			}
		} else {
			return ResponseEntity.badRequest().body("Cannot find the Customer specified");
		}
	}

	@Override
	public ResponseEntity<?> addCustomerDetails(Customers transientpojo, int cityid) {

		Optional<Customers> c = dao.findByEmail(transientpojo.getEmail());
		if (c.isPresent()) {
			System.out.println(c);
			return ResponseEntity.badRequest().body("The Customer is already Present, Fail to create");
		} else {
			transientpojo.setCcityId(cityDao.getOne(cityid));
			dao.save(transientpojo);
			System.out.println(transientpojo);
			return ResponseEntity.ok("Account Created");
		}
	}

}
