package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.ResourceNotFoundException;
import com.app.dao.ISupplierServicesDao;
import com.app.pojos.Supplier_Services;
@Service
@Transactional
public class Suplier_ServiceServiceImpl implements ISupplier_ServiceService {

	@Autowired
	private ISupplierServicesDao dao;
	@Override
	public List<Supplier_Services> getAllSupplierServices() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Supplier_Services addSupplierServiceDetails(Supplier_Services ss) {
		// TODO Auto-generated method stub
		return dao.save(ss);
	}

	@Override
	public Supplier_Services updateSupplierServiceDetails(int id,Supplier_Services detachedPOJO) {
		Optional<Supplier_Services> s = dao.findById(id);
		if (s.isPresent()) {
			Supplier_Services service = s.get();
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
		// TODO Auto-generated method stub
dao.deleteById(id);
	}

}
