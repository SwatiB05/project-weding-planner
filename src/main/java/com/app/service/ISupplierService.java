package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.SupplierDTO;
import com.app.pojos.Suppliers;

public interface ISupplierService {

	List<Suppliers> getAllSuppliers();
	
	public ResponseEntity<?> addSupplierDetails(Suppliers s);

	ResponseEntity<?> updateSupplierDetails(int supplierId, Suppliers detachedPOJO);
	
	ResponseEntity<?> deleteSupplierById(int id);

	SupplierDTO findById(int supplierId);
	ResponseEntity<?> updateSupplierStatus(int id);
	ResponseEntity<?> supplierAuthentication(String email, String password);

}
