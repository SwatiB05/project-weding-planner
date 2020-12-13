package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Customers;
import com.app.service.ICustomerService;

@RestController

public class AdminController {

	@Autowired
	private ICustomerService service;

	public AdminController() {
		// TODO Auto-generated constructor stub
		System.out.println("in const admin");
	}
	

	// API endpoint or providers

	@GetMapping("/admin/customers") // to set header and body use response entity

	public ResponseEntity<?> listAllCustomers() {
		List<Customers> allCustomers = service.getAllCustomers();

		if (allCustomers.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(allCustomers);
	}

}
