package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ISupplierDao;
import com.app.pojos.Suppliers;

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
	public ResponseEntity<?> updateSupplierDetails(int supplierId, Suppliers detachedPOJO) {
		// TODO Auto-generated method stub
		Optional<Suppliers> c = dao.findById(supplierId);
		if (c.isPresent()) {
			// c.get() : PERSISTENT
			// cityDetachPojo : detached POJO : contains the updates sent by clnt
			// change state of persistent POJO
			Suppliers s = c.get();
			s.setFirstName(detachedPOJO.getFirstName());
			s.setLastName(detachedPOJO.getLastName());
			s.setEmail(detachedPOJO.getEmail());
			s.setPhoneNo(detachedPOJO.getPhoneNo());
			s.setPassword(detachedPOJO.getPassword());
			s.setSupplierAddress(detachedPOJO.getSupplierAddress());
			 return  ResponseEntity.accepted().body("Supplier updated successfully"); 
		}
		else return ResponseEntity.badRequest().body("Cannot find the Supplier specified");

	}

	@Override
	public ResponseEntity<?> addSupplierDetails(Suppliers s) {
		// TODO Auto-generated method stub
		Optional<Suppliers> c = dao.findByEmail(s.getEmail());
		if (c.isPresent()) {
			return ResponseEntity.badRequest().body("The Supplier is already Present, Fail to create");
		} else {
			dao.save(s);
			return ResponseEntity.ok("Supplier Created Successfully");
		}
	}
	

	@Override
	public Optional<Suppliers> findById(int supplierId) {
		return dao.findById(supplierId);
	}

	@Override
	public ResponseEntity<?> deleteSupplierById(int id) {
		Optional<Suppliers> c = dao.findById(id);
		if (c.isPresent()) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("Successfully deleted the specified Supplier");
		} else {
			return ResponseEntity.badRequest().body("Cannot find the specified Supplier");
		}
	}
	
	
	@Override
	public ResponseEntity<?> adminAuthentication(String email, String password) {
		Optional<Suppliers> admin = dao.findByEmail(email);
		if(admin.isPresent()) {
			if(admin.get().getPassword()==password) {
				return ResponseEntity.ok("Login Sucessfull");
			}else {
				return ResponseEntity.badRequest().body("Wrong PassWord");
			}
		}else {
			return ResponseEntity.badRequest().body("Invalid Credentials...");
		}
	}


}

