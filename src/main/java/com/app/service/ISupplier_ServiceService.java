package com.app.service;

import java.util.List;

import com.app.pojos.Supplier_Services;

public interface ISupplier_ServiceService {

	List<Supplier_Services> getAllSupplierServices();
	
	Supplier_Services addSupplierServiceDetails(Supplier_Services ss);
	
	Supplier_Services updateSupplierServiceDetails(int id,Supplier_Services ss);
	
	void deleteSupplierServiceById(int id);

}
