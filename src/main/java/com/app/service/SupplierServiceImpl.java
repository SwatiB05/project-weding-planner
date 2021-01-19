package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICitiesDao;
import com.app.dao.ISupplierDao;
import com.app.dto.SupplierDTO;
import com.app.pojos.Cities;
import com.app.pojos.Suppliers;

@Service
@Transactional
public class SupplierServiceImpl implements ISupplierService {

	// dependency
	@Autowired
	private ISupplierDao dao;
	@Autowired
	private ICitiesDao cityDao;

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
			Suppliers s = c.get();
			
			detachedPOJO.setScityId(cityDao.getOne(detachedPOJO.getScityId().getCityId()));
			System.out.println(detachedPOJO.getScityId().getCity());
			s.setFirstName(detachedPOJO.getFirstName());
			s.setLastName(detachedPOJO.getLastName());
			s.setEmail(detachedPOJO.getEmail());
			s.setPhoneNo(detachedPOJO.getPhoneNo());
			s.setPassword(detachedPOJO.getPassword());
			s.setSupplierAddress(detachedPOJO.getSupplierAddress());
			s.setScityId(detachedPOJO.getScityId());
			System.out.println(s.getScityId().getCity());
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
			s.setScityId(cityDao.getOne(s.getScityId().getCityId()));
			dao.save(s);
			return ResponseEntity.ok("Supplier Created Successfully");
		}
	}
	

	@Override
	public SupplierDTO findById(int supplierId) {
			Optional<Suppliers>s=dao.findById(supplierId);
			return new SupplierDTO(s.get());
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
	public ResponseEntity<?> supplierAuthentication(String email, String password) {
		Optional<Suppliers> s = dao.findByEmail(email);
		if(s.isPresent()) {
			if(s.get().getPassword().contentEquals(password)) {
				return ResponseEntity.ok(new SupplierDTO(s.get()));
			}else {
				return ResponseEntity.badRequest().body("Wrong PassWord");
			}
		}else {
			return ResponseEntity.badRequest().body("Invalid Credentials...");
		}
	}

	@Override
	public ResponseEntity<?> updateSupplierStatus(int id) {
		Optional<Suppliers> c = dao.findById(id);
		if (c.isPresent()) {
			int num = c.get().getIsActive().intValue();
			System.out.println(num);
			if (num == 1) {
				int n=0;
				c.get().setIsActive(n);
				System.out.println(c.get().getIsActive().intValue());
				return ResponseEntity.ok().body("Suspend Supplier");
			} else {
				int n=1;
				c.get().setIsActive(n);
				System.out.println(c.get().getIsActive().intValue());
				return ResponseEntity.ok().body("Activate Supplier");
			}
		} else {
			return ResponseEntity.badRequest().body("Cannot find the Supplier specified");
		}
	}
}

