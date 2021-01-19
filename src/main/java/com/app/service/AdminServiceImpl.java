package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.dto.AdminDTO;
import com.app.pojos.Admin;
@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao dao;
	
	@Override
	public ResponseEntity<?> adminAuthentication(String email, String password) {
		Optional<Admin> admin = dao.findByEmail(email);
		if(admin.isPresent()) {
			if(admin.get().getPassword().contentEquals(password)) {
				return ResponseEntity.ok(admin.get().getAdminId());
				
			}else {
				return ResponseEntity.badRequest().body("Wrong PassWord");
			}
		}else {
			return ResponseEntity.badRequest().body("Invalid Credentials...");
		}
	}

}
