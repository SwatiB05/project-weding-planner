package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Customers;

public interface ICustomerService {
	List<Customers> getAllCustomers();

	ResponseEntity<?> addCustomerDetails(Customers transientpojo, int cityid);

	ResponseEntity<?> updateCustomerDetails(int customerId, Customers detachedPOJO);

	ResponseEntity<?> deleteCustomerById(int customerId);

	ResponseEntity<?> updateCustomerStatus(int id);

	ResponseEntity<?> getCustomer(int customerId);

	ResponseEntity<?> customerAuthentication(String email, String password);
}
