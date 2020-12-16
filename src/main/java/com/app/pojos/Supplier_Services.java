package com.app.pojos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Supplier_Services")
public class Supplier_Services {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplierServiceId;

	@JsonIgnore
	@ManyToMany(mappedBy = "serviceSupplierDetails")
	private Set<Bookings> bookings;

	@ManyToOne
	@JoinColumn(name = "supplierId")
	private Suppliers supplierId;

	@ManyToOne
	@JoinColumn(name = "serviceId")
	private Services serviceId;

	@Column(length = 20)
	private double charges;

	
	// getter...

	public Integer getSupplierServiceId() {
		return supplierServiceId;
	}

	public void setSupplierServiceId(Integer supplierServiceId) {
		this.supplierServiceId = supplierServiceId;
	}

	public Suppliers getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Suppliers supplierId) {
		this.supplierId = supplierId;
	}

	public Services getServiceId() {
		return serviceId;
	}

	public void setServiceId(Services serviceId) {
		this.serviceId = serviceId;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	public Set<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Supplier_Services [supplierServiceId=" + supplierServiceId + ", bookings=" + bookings + ", supplierId="
				+ supplierId + ", serviceId=" + serviceId + ", charges=" + charges + "]";
	}

}
