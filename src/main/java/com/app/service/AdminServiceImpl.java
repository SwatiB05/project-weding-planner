package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.app.dao.IAdminDao;
import com.app.pojos.Admin;

public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao dao;
	
	@Override
	public ResponseEntity<?> adminAuthentication(String email, String password) {
		Optional<Admin> admin = dao.findByEmail(email);
		if(admin.isPresent()) {
			if(admin.get().getPassword()==password) {
				return ResponseEntity.ok("Login Sucessfull");
			}
			return ResponseEntity.badRequest().body("Wrong PassWord");
		}
		return ResponseEntity.badRequest().body("Invalid Credentials...");
	}

}
