package com.app.service;

import org.springframework.http.ResponseEntity;

public interface IAdminService {

	ResponseEntity<?> adminAuthentication(String name,String password);
}
