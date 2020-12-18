package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.ResourceNotFoundException;
import com.app.dao.ISupplierDao;
import com.app.pojos.Suppliers;

@Service 
@Transactional
public class SupplierServiceImpl implements ISupplierService {

	//dependency 
		@Autowired
		private ISupplierDao dao;
	@Override
	public List<Suppliers> getAllSuppliers() {
		System.out.println("in suppliers get all");
		return dao.findAll();
		
	}

	@Override
	public void deleteSupplierById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

@Override
public Suppliers updateSupplierDetails(int supplierId, Suppliers detachedPOJO) {
	// TODO Auto-generated method stub 
	Optional<Suppliers> s =dao.findById(supplierId);
	if (s.isPresent()) {
  Suppliers supplier = s.get();
  //supplier.setCcityId(detachedPOJO.getCcityId());
  supplier.setFirstName(detachedPOJO.getFirstName());
  supplier.setLastName(detachedPOJO.getLastName());
  supplier.setSupplierAddress(detachedPOJO.getSupplierAddress());
  supplier.setEmail(detachedPOJO.getEmail());
  supplier.setPhoneNo(detachedPOJO.getPhoneNo());
  return supplier;
  
  }
	throw new ResourceNotFoundException("Invalid Customer..");
	
}

@Override
public Suppliers addSupplierDetails(Suppliers s) {
	// TODO Auto-generated method stub
	return dao.save(s);
}
}