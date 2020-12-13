package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Suppliers;

public interface ISupplierDao extends JpaRepository<Suppliers,Integer>{

}
