package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Facilities;

public interface IFacilityDao extends JpaRepository<Facilities, Integer>{

}
