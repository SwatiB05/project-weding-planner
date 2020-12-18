package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_excpt.ResourceNotFoundException;
import com.app.dao.ICitiesDao;
import com.app.pojos.Cities;

@Service
@Transactional
public class CityServicesImpl implements ICityService {

	@Autowired
	private ICitiesDao dao;

	@Override
	public List<Cities> getAllCities() {
		return dao.findAll();
	}

	@Override
	public Cities addCityDetails(Cities transientpojo) {
		// TODO Auto-generated method stub
		return dao.save(transientpojo);
	}

	@Override
	public Cities updateCityDetails(int cityId, Cities cityDetachPojo) {
		// chk if city exists : findById
		Optional<Cities> c = dao.findById(cityId);
		if (c.isPresent()) {
			// c.get() : PERSISTENT
			// cityDetachPojo : detached POJO : contains the updates sent by clnt
			// change state of persistent POJO
			Cities city = c.get();
			city.setCity(cityDetachPojo.getCity());
			return city;

		}
		// in case of no product found : throw custom exception
		throw new ResourceNotFoundException("Invalid City ID");

	}

	@Override
	public void deleteCityById(int cityId) {
		
			dao.deleteById(cityId);
	
	}

}
