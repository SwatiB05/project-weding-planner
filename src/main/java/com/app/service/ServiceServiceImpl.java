package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IServiceDao;
import com.app.pojos.Services;

@Service
@Transactional
public class ServiceServiceImpl implements IServiceService {

	@Autowired
	private IServiceDao dao;
	@Override
	public List<Services> getAllServices() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	
	@Override
	public ResponseEntity<?> findById(int id) {
		Optional<Services> c = dao.findById(id);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else
			return ResponseEntity.badRequest().body("Cannot find the specified Service");
	}
	
	
	@Override
	public ResponseEntity<?> addServiceDetails(Services s) {
		Optional<Services> c = dao.findByServiceName(s.getServiceName());
		if (c.isPresent()) {
			return ResponseEntity.badRequest().body("The Services is already Present, Fail to create");
		} else {
			dao.save(s);
			return ResponseEntity.ok("Services Created Successfully");
		}
	}
	@Override
	public ResponseEntity<?> updateServiceDetails(String service, Services detachedPOJO) {
		Optional<Services> c = dao.findByServiceName(service);
		if (c.isPresent()) {
			// c.get() : PERSISTENT
			// cityDetachPojo : detached POJO : contains the updates sent by clnt
			// change state of persistent POJO
			Services s = c.get();
			s.setServiceName(detachedPOJO.getServiceName());
			 return  ResponseEntity.accepted().body("Service updated successfully"); 
		}
		else return ResponseEntity.badRequest().body("Cannot find the Service specified");

	}
	
	@Override
	public ResponseEntity<?> deleteServiceById(int id) {
		Optional<Services> c = dao.findById(id);
		if (c.isPresent()) {
			dao.deleteById(id);
			return ResponseEntity.ok().body("Successfully deleted the specified city");
		} else {
			return ResponseEntity.badRequest().body("Cannot find the City specified");
		}
	}


	@Override
	public ResponseEntity<?> findByName(String service) {
		Optional<Services> c = dao.findByServiceName(service);
		if (c.isPresent()) {
			return ResponseEntity.ok(c);
		} else
			return ResponseEntity.badRequest().body("Cannot find the specified Service");
	
	}
}
	


