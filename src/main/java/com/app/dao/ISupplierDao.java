package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Suppliers;

public interface ISupplierDao extends JpaRepository<Suppliers,Integer>{
	Optional<Suppliers> findByEmail(String email);
}
