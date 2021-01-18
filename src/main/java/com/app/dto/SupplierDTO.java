package com.app.dto;

import java.util.Date;

import com.app.pojos.Cities;
import com.app.pojos.Suppliers;

public class SupplierDTO {

	private Integer supplierId;

	private String firstName;

	private String lastName;

	private String supplierAddress;

	private String phoneNo;

	private Cities scityId;

	private String email;

	private Date createdOn;

	private Integer isActive;

	public SupplierDTO(Suppliers s) {
		super();
		this.supplierId = s.getSupplierId();
		this.firstName = s.getFirstName();
		this.lastName = s.getLastName();
		this.supplierAddress = s.getSupplierAddress();
		this.phoneNo = s.getPhoneNo();
		this.scityId = s.getScityId();
		this.email = s.getEmail();
		this.createdOn = s.getCreatedOn();
		this.isActive = s.getIsActive();
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
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

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Cities getScityId() {
		return scityId;
	}

	public void setScityId(Cities scityId) {
		this.scityId = scityId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	
	

}
