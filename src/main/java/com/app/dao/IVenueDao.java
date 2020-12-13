package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Venues;

public interface IVenueDao extends JpaRepository<Venues,Integer>{

}
