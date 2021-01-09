package com.app.service;

import java.util.List;

import com.app.pojos.SupplierServices;

public interface ISupplierServicesService {

	List<SupplierServices> getAllSupplierServices();
	
	SupplierServices addSupplierServiceDetails(SupplierServices ss);
	
	SupplierServices updateSupplierServiceDetails(int id,SupplierServices ss);
	
	void deleteSupplierServiceById(int id);

}
