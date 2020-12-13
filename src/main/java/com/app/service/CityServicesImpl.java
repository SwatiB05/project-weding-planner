package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

}
