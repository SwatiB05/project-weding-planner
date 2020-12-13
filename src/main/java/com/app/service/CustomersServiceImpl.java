package com.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	
	
}
