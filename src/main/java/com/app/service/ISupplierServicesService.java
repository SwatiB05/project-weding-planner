package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.SupplierServices;

public interface ISupplierServicesService {

	List<SupplierServices> getAllSupplierServices();
	
	ResponseEntity<?> addSupplierServiceDetails(SupplierServices ss);
	
	ResponseEntity<?> updateSupplierServiceDetails(int id,SupplierServices ss);
	
	ResponseEntity<?> deleteSupplierServiceById(int id);

}
