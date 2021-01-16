package com.app.dto;

import com.app.pojos.Admin;

public class AdminDTO {

	private Integer adminId;

	private String firstName;

	private String lastName;

	private String phoneNo;

	private String email;

	public AdminDTO(Admin a) {
		super();
		this.adminId = a.getAdminId();
		this.firstName = a.getFirstName();
		this.lastName = a.getLastName();
		this.phoneNo = a.getPhoneNo();
		this.email = a.getEmail();
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
