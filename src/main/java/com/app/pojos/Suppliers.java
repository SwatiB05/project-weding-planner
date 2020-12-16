package com.app.pojos;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "Suppliers")
public class Suppliers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplierId;

	
  /*@JsonManagedReference
    //@JsonIgnoreProperties
	@OneToMany(mappedBy = "supplierId",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
=======*/

	@JsonIgnore
	@OneToMany(mappedBy = "supplierId", cascade = CascadeType.ALL)
	private Set<Supplier_Services> Supplier_Services;

	@Column(length = 30)
	private String firstName;

	@Column(length = 30)
	private String lastName;

	@Column(length = 60)
	private String supplierAddress;

	@Column(length = 15)
	private String phoneNo;

	
	
	/*//@JsonIgnoreProperties
	@JsonBackReference(value = "supplier")
    @ManyToOne(optional = false)
	@JoinColumn(name = "cityId", nullable = false)
	private Cities scityId;*/
	

	@ManyToOne
	@JoinColumn(name = "cityId",nullable = false)
	private Cities scityId;


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
	private Integer isActive;

	// getter setters

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Set<Supplier_Services> getSupplier_Services() {
		return Supplier_Services;
	}

	public void setSupplier_Services(Set<Supplier_Services> supplier_Services) {
		Supplier_Services = supplier_Services;
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

	/*
	 * <<<<<<< HEAD
	 * 
	 * ======= >>>>>>> 86581aea8a2bf20c57519149575d3bace409f0d1 public Cities
	 * getScityId() { return scityId; }
	 * 
	 * <<<<<<< HEAD
	 * 
	 * ======= >>>>>>> 86581aea8a2bf20c57519149575d3bace409f0d1
	 */
	public void setScityId(Cities scityId) {
		this.scityId = scityId;
	}

	@Override
	public String toString() {
		return "Suppliers [supplierId=" + supplierId + ", Supplier_Services=" + Supplier_Services + ", firstName="
				+ firstName + ", lastName=" + lastName + ", supplierAddress=" + supplierAddress + ", phoneNo=" + phoneNo
				+ ", scityId=" + scityId + ", email=" + email + ", createdOn=" + createdOn + ", isActive=" + isActive
				+ "]";
	}

}
