


package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
	public ResponseEntity<?> addCityDetails(Cities transientpojo) {
		// TODO Auto-generated method stub
		Optional<Cities> c = dao.findById(transientpojo.getCityId());
		if (c.isPresent()) {
			 return ResponseEntity.badRequest().body("The city is already Present, Failed to create");
		}
		dao.save(transientpojo);
		return ResponseEntity.ok("City added Successfully");
		//return dao.save(transientpojo);
	}

	@Override
	public ResponseEntity<?> updateCityDetails(int cityId, Cities cityDetachPojo) {
		// chk if city exists : findById
		Optional<Cities> c = dao.findById(cityId);
		if (c.isPresent()) {
			// c.get() : PERSISTENT
			// cityDetachPojo : detached POJO : contains the updates sent by clnt
			// change state of persistent POJO
			Cities city = c.get();
			city.setCity(cityDetachPojo.getCity());
			 return  ResponseEntity.accepted().body("City updated successfully"); 

		}
		else return ResponseEntity.unprocessableEntity().body("Cannot find the City specified");

	}

	@Override
	public ResponseEntity<?> deleteCityById(int cityId) {
		Optional<Cities> c = dao.findById(cityId);
		if (c.isPresent()) {
			dao.deleteById(cityId);
			if(c.isPresent()) {
				return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified City it is associated with other venue,customer,supplier");	
			}else
			{
			 return ResponseEntity.ok().body("Successfully deleted the specified city");
			}
		}else {
			return ResponseEntity.badRequest().body("Cannot find the City specified");
		}

	
	}

}