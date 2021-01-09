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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Suppliers")
public class Suppliers {

	@Id
	//@JsonManagedReference
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplierId;

	@JsonIgnore
	//@JsonIgnoreProperties("supplierId")
	@OneToMany(mappedBy = "supplierId", cascade = CascadeType.ALL)
	private Set<SupplierServices> supplierServices;

	@Column(length = 30)
	private String firstName;

	@Column(length = 30)
	private String lastName;

	@Column(length = 60)
	private String supplierAddress;

	@Column(length = 15)
	private String phoneNo;

	
	@ManyToOne
	@JsonIgnoreProperties("suppliers")
	@JoinColumn(name = "cityId",nullable = false)
	private Cities scityId;


	@Column(length = 30,unique = true)
	private String email;

	@Column(length = 100)
	private String password;

	@Temporal(TemporalType.DATE)
	@Column(columnDefinition = "DATE default (CURRENT_DATE)", updatable = false)
	@CreatedDate
	@JsonProperty(value = "Acount-creation-Date")
	private Date createdOn;

	@Column(columnDefinition = "tinyint(1) default 0")
	private Integer isActive;

	// getter setters

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

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Cities getScityId() {
		return scityId;
	}

	public void setScityId(Cities scityId) {
		this.scityId = scityId;
	}


	public Set<SupplierServices> getSupplierServices() {
		return supplierServices;
	}

	public void setSupplierServices(Set<SupplierServices> supplierServices) {
		this.supplierServices = supplierServices;
	}

	@Override
	public String toString() {
		return "Suppliers [supplierId=" + supplierId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", supplierAddress=" + supplierAddress + ", phoneNo=" + phoneNo + ", scityId=" + scityId + ", email="
				+ email + ", createdOn=" + createdOn + ", isActive=" + isActive + "]";
	}

	

	

}
