package com.app.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.CustomerNotFoundException;
import com.app.dao.ICustomerDao;
import com.app.pojos.Customers;

@Service 
@Transactional
public class CustomersServiceImpl implements ICustomerService {

	
	//dependency 
	@Autowired
	private ICustomerDao dao;

	@Override
	public List<Customers> getAllCustomers() {
		System.out.println("in service get all");
		return dao.findAll();
	}

	@Override
	public Customers addCustomerDetails(Customers transientpojo) {
		// TODO Auto-generated method stub
		return dao.save(transientpojo);
	}

	@Override
	public Customers updateCustomerDetails(int customerId, Customers detachedPOJO) {
		Optional<Customers> c = dao.findById(customerId);
		if (c.isPresent()) {
			// c.get() : PERSISTENT
			// cityDetachPojo : detached POJO : contains the updates sent by clnt
			// change state of persistent POJO
			Customers customer = c.get();
			customer.setCcityId(detachedPOJO.getCcityId());
			customer.setFirstName(detachedPOJO.getFirstName());
			customer.setLastName(detachedPOJO.getLastName());
			customer.setCustomerAddress(detachedPOJO.getCustomerAddress());
			customer.setEmail(detachedPOJO.getEmail());
			customer.setPhoneNo(detachedPOJO.getPhoneNo());
			return customer;

		}
		// in case of no product found : throw custom exception
		throw new CustomerNotFoundException("Invalid Customer ID");

	}

	@Override
	public void deleteCustomerById(int customerId) {
			dao.deleteById(customerId);	
	}
	
	
	
}
