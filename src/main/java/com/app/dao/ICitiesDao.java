package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Cities;

public interface ICitiesDao extends JpaRepository<Cities,Integer> {

}
