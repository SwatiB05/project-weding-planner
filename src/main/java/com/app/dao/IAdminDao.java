package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Admin;


public interface IAdminDao extends JpaRepository<Admin,Integer> {
	//String login(Admin transientAdmin)
	Optional<Admin> findByEmail(String email);
}
