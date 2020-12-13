package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Bookings;

public interface IBookingDao extends JpaRepository<Bookings,Integer>{

}
