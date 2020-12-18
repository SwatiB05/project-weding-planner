package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.ResourceNotFoundException;
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
	public Services addServiceDetails(Services s) {
		// TODO Auto-generated method stub
		return dao.save(s);
	}
	@Override
	public Services updateServiceDetails(int Id, Services detachedPOJO) {
		Optional<Services> c = dao.findById(Id);
		if (c.isPresent()) {
			// c.get() : PERSISTENT
			// cityDetachPojo : detached POJO : contains the updates sent by clnt
			// change state of persistent POJO
			Services service = c.get();
			service.setServiceName(detachedPOJO.getServiceName());
			return service;

		}
		// in case of no product found : throw custom exception
		throw new ResourceNotFoundException("Invalid Supplier...");

	}
	@Override
	public void deleteServiceById(int Id) {
		// TODO Auto-generated method stub
		dao.deleteById(Id);
	}
	

}
