package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.ResourceNotFoundException;
import com.app.dao.ISupplierServicesDao;
import com.app.pojos.Services;
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
	public SupplierServices addSupplierServiceDetails(SupplierServices ss) {
		// TODO Auto-generated method stub
		return dao.save(ss);
	}

	@Override
	public SupplierServices updateSupplierServiceDetails(int id,SupplierServices detachedPOJO) {
		Optional<SupplierServices> s = dao.findById(id);
		if (s.isPresent()) {
			SupplierServices service = s.get();
			service.setBookings(detachedPOJO.getBookings());
			service.setCharges(detachedPOJO.getCharges());
			service.setServiceId(detachedPOJO.getServiceId());
			service.setSupplierId(detachedPOJO.getSupplierId());
			return service;
		}
		// in case of no product found : throw custom exception
		throw new ResourceNotFoundException("Invalid supplier service..");

	}

	@Override
	public void deleteSupplierServiceById(int id) {
		Optional<SupplierServices> c = dao.findById(id);
		if (c.isPresent()) {
			dao.deleteById(id);
		}
		throw new ResourceNotFoundException("Invalid SupplierServices ID");
	}

}
