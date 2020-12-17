package com.app.pojos;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Customers")

public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;


	@JsonIgnore
	@OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL)
	private Set<Bookings> bookings;

	@Column(length = 30)
	private String firstName;

	@Column(length = 30)
	private String lastName;

	@Column(length = 60)
	private String customerAddress;

	@Column(length = 15)
	private String phoneNo;


	@ManyToOne
	@JoinColumn(name = "cityId",nullable = false)
	private Cities ccityId;

	@Column(length = 30)
	private String email;

	@Column(length = 100)
	private String password;

	@Temporal(TemporalType.DATE)
	@Column(columnDefinition = "DATE default (CURRENT_DATE)", updatable = false)
	@CreatedDate
	@JsonProperty(value = "Acount-creation-Date")
	private Date createdOn;

	@Column(columnDefinition = "tinyint(1) default 0")
	private Integer status;

	@Column(columnDefinition = "tinyint(1) default 0")
	private Integer isActive;

	// getter setters
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Set<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
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


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Cities getCcityId() {
		return ccityId;
	}

	public void setCcityId(Cities ccityId) {
		this.ccityId = ccityId;
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", bookings=" + bookings + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", customerAddress=" + customerAddress + ", phoneNo=" + phoneNo
				+ ", ccityId=" + ccityId + ", email=" + email + ", createdOn=" + createdOn + ", status=" + status
				+ ", isActive=" + isActive + "]";
	}

}
