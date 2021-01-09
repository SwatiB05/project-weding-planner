package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Suppliers;

public interface ISupplierService {

	List<Suppliers> getAllSuppliers();
	
	public Suppliers addSupplierDetails(Suppliers s);

	Suppliers updateSupplierDetails(int supplierId, Suppliers detachedPOJO);
	
	void deleteSupplierById(int id);

	Optional<Suppliers> findById(int supplierId);

	ResponseEntity<?> adminAuthentication(String email, String password);

}
