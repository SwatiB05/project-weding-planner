package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ISupplierServicesDao;
import com.app.pojos.SupplierServices;
@Service
@Transactional
public class SupplierServicesServiceImpl implements ISupplierServicesService {

	@Autowired
	private ISupplierServicesDao dao;
	@Override
	public List<SupplierServices> getAllSupplierServices() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public ResponseEntity<?> addSupplierServiceDetails(SupplierServices ss) {
		// TODO Auto-generated method stub
		Optional<SupplierServices> c = dao.findById(ss.getSupplierServiceId());
		if (c.isPresent()) {
			return ResponseEntity.badRequest().body("The SupplierService is already Present, Fail to create");
		} else {
		
			dao.save(ss);
			return ResponseEntity.ok("SupplierService Created Successfully");
		}
		
	}

	@Override
	public ResponseEntity<?> updateSupplierServiceDetails(int id,SupplierServices detachedPOJO) {
		Optional<SupplierServices> s = dao.findById(id);
		if (s.isPresent()) {
			SupplierServices service = s.get();
			service.setBookings(detachedPOJO.getBookings());
			service.setCharges(detachedPOJO.getCharges());
			service.setServiceId(detachedPOJO.getServiceId());
			service.setSupplierId(detachedPOJO.getSupplierId());
			return  ResponseEntity.accepted().body("SupplierService updated successfully"); 
		}
		else return ResponseEntity.badRequest().body("Cannot find the SupplierService specified");
	}

	@Override
	public ResponseEntity<?> deleteSupplierServiceById(int id) {
		Optional<SupplierServices> c = dao.findById(id);
		if (c.isPresent()) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("Successfully deleted the specified SupplierService");
		} else {
			return ResponseEntity.badRequest().body("Cannot find the specified SupplierService");
		}
}
}
