package com.app.pojos;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "SupplierServices")
public class SupplierServices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplierServiceId;

	// @JsonIgnore
	@JsonIgnoreProperties("serviceSupplierDetails")
	@ManyToMany(mappedBy = "serviceSupplierDetails", fetch = FetchType.LAZY,
	targetEntity = Bookings.class, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	private Set<Bookings> bookings;

	@ManyToOne
	@JsonIgnoreProperties("supplierServices")
	@JoinColumn(name = "supplierId")
	@Basic(optional = true)
	// @JsonBackReference
	private Suppliers supplierId;

	@ManyToOne
	@JsonIgnoreProperties("supplierServices")
	@JoinColumn(name = "serviceId")
	@Basic(optional = true)
	private Services serviceId;

	@Column(length = 20)
	private Double charges;

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

	public Double getCharges() {
		return charges;
	}

	public void setCharges(Double charges) {
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
		return "SupplierServices [supplierServiceId=" + supplierServiceId + ", supplierId=" + supplierId
				+ ", serviceId=" + serviceId + ", charges=" + charges + "]";
	}

}
