package com.app.dto;

import java.util.Date;

import com.app.pojos.Cities;
import com.app.pojos.Customers;

public class CustomerDTO {
	private Integer customerId;

	private String firstName;

	private String lastName;

	private String customerAddress;

	private String phoneNo;

	private Cities ccityId;

	private String email;

	private Date createdOn;

	private Integer status;

	private Integer isActive;

	public CustomerDTO(Customers c) {
		super();
		this.customerId = c.getCustomerId();
		this.firstName = c.getFirstName();
		this.lastName = c.getLastName();
		this.customerAddress = c.getCustomerAddress();
		this.phoneNo = c.getPhoneNo();
		this.ccityId = c.getCcityId();
		this.email = c.getEmail();
		this.createdOn = c.getCreatedOn();
		this.status = c.getStatus();
		this.isActive = c.getIsActive();
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Cities getCcityId() {
		return ccityId;
	}

	public void setCcityId(Cities ccityId) {
		this.ccityId = ccityId;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}
