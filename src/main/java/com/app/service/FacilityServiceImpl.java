package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpt.ResourceNotFoundException;
import com.app.dao.IFacilityDao;
import com.app.pojos.Customers;
import com.app.pojos.Facilities;

@Service
@Transactional
public class FacilityServiceImpl implements IFacilitesService {

	@Autowired
	private IFacilityDao dao;

	@Override
	public List<Facilities> getAllFacilities() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Facilities addFacilityDetails(Facilities f) {
		// TODO Auto-generated method stub
		return dao.save(f);
	}

	@Override
	public Facilities updateFacilityDetails(int facilityId, Facilities detachedPOJO) {
		// TODO Auto-generated method stub
		Optional<Facilities> f = dao.findById(facilityId);
		if (f.isPresent()) {
			Facilities facility = f.get();
			facility.setFacilityName(detachedPOJO.getFacilityName());
			return facility;
		}
		throw new ResourceNotFoundException("No Such Facility...");
	}

	@Override
	public void deleteFacilityById(int id) {
		Optional<Facilities> c = dao.findById(id);
		if (c.isPresent()) {
			dao.deleteById(id);
		}
		throw new ResourceNotFoundException("Invalid Facility ID");

	}

}
