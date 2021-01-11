package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Facilities;

public interface IFacilityDao extends JpaRepository<Facilities, Integer>{
	Optional<Facilities> findByFacilityName(String service);

}
