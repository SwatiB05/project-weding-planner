package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Bookings;

public interface IBookingDao extends JpaRepository<Bookings,Integer>{
	List<Bookings> findByCustomerId(int id);
}
