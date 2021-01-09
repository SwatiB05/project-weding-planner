package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.ResourceNotFoundException;
import com.app.dao.ISupplierDao;
import com.app.pojos.Customers;
import com.app.pojos.Suppliers;
import com.app.pojos.VenueFacilities;

@Service
@Transactional
public class SupplierServiceImpl implements ISupplierService {

	// dependency
	@Autowired
	private ISupplierDao dao;

	@Override
	public List<Suppliers> getAllSuppliers() {
		System.out.println("in suppliers get all");
		return dao.findAll();

	}

	@Override
	public Suppliers updateSupplierDetails(int supplierId, Suppliers detachedPOJO) {
		// TODO Auto-generated method stub
		Optional<Suppliers> s = dao.findById(supplierId);
		if (s.isPresent()) {
			Suppliers supplier = s.get();
			// supplier.setCcityId(detachedPOJO.getCcityId());
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

	@Override
	public Optional<Suppliers> findById(int supplierId) {
		// TODO Auto-generated method stub
		return dao.findById(supplierId);
	}

	@Override
	public void deleteSupplierById(int id) {
		Optional<Suppliers> c = dao.findById(id);
		if (c.isPresent()) {
			dao.deleteById(id);
		}
		throw new ResourceNotFoundException("Invalid Suppliers ID");
	}
	
	
	@Override
	public ResponseEntity<?> adminAuthentication(String email, String password) {
		Optional<Suppliers> admin = dao.findByEmail(email);
		if(admin.isPresent()) {
			if(admin.get().getPassword()==password) {
				return ResponseEntity.ok("Login Sucessfull");
			}
			return ResponseEntity.badRequest().body("Wrong PassWord");
		}
		return ResponseEntity.badRequest().body("Invalid Credentials...");
	}
}