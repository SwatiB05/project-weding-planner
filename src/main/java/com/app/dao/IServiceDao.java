package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Services;

public interface IServiceDao extends JpaRepository<Services,Integer> {
	Optional<Services> findByServiceName(String service);
}
