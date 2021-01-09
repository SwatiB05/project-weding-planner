package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Suppliers;

public interface ISupplierService {

	List<Suppliers> getAllSuppliers();
	
	public ResponseEntity<?> addSupplierDetails(Suppliers s);

	ResponseEntity<?> updateSupplierDetails(int supplierId, Suppliers detachedPOJO);
	
	ResponseEntity<?> deleteSupplierById(int id);

	Optional<Suppliers> findById(int supplierId);

	ResponseEntity<?> adminAuthentication(String email, String password);

}
