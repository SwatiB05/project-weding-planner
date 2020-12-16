package com.app.service;

import java.util.List;

import com.app.pojos.Suppliers;

public interface ISupplierService {

	List<Suppliers> getAllSuppliers();
	
	public Suppliers addSupplierDetails(Suppliers s);

	Suppliers updateSupplierDetails(int supplierId, Suppliers detachedPOJO);
	
	void deleteSupplierById(int id);

	

}
