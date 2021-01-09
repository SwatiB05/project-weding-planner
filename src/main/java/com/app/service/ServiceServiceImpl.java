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
	public ResponseEntity<?> addServiceDetails(Services s) {
		// TODO Auto-generated method stub
		Optional<Services> c = dao.findById(s.getServiceId());
		if (c.isPresent()) {
			 return ResponseEntity.badRequest().body("The service is already Present, Failed to create");
		}
		dao.save(s);
		return ResponseEntity.ok("Service added Successfully");
	}
	@Override
	public ResponseEntity<?> updateServiceDetails(int Id, Services detachedPOJO) {
		Optional<Services> c = dao.findById(Id);
		if (c.isPresent()) {
			// c.get() : PERSISTENT
			// cityDetachPojo : detached POJO : contains the updates sent by clnt
			// change state of persistent POJO
			Services s = c.get();
			s.setServiceName(detachedPOJO.getServiceName());
			 return  ResponseEntity.accepted().body("Service updated successfully"); 

		}
		else return ResponseEntity.unprocessableEntity().body("Cannot find the Service specified");

	}
	
	@Override
	public ResponseEntity<?> deleteServiceById(int id) {
		Optional<Services> c = dao.findById(id);
		if (c.isPresent()) {
			dao.deleteById(id);
			if(c.isPresent()) {
				return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified Services it is associated with other supplier-Services");	
			}else
			{
			 return ResponseEntity.ok().body("Successfully deleted the specified Service");
			}
		}else {
			return ResponseEntity.badRequest().body("Cannot find the Service specified");
		}
	}
}
	


