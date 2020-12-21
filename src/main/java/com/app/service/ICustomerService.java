package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Customers;

public interface ICustomerService {
	List<Customers> getAllCustomers();

	Customers addCustomerDetails(Customers transientpojo);

	Customers updateCustomerDetails(int customerId, Customers detachedPOJO);

	void deleteCustomerById(int customerId);

	
	Optional<Customers> findById(int customerId);
}
