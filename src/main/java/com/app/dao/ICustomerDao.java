package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Customers;

public interface ICustomerDao extends JpaRepository<Customers,Integer> { 
	Optional<Customers> findByEmail(String email);
	
}
