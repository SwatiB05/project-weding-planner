package com.app.pojos;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "Supplier_Services")
public class Supplier_Services {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplierServiceId;
	
	
	@JsonManagedReference
    @JsonIgnore
	@OneToMany(mappedBy = "supplierServiceId",cascade = CascadeType.ALL)
	private Set<Booking_Detof_Service_Suppliers> supplierserviceDetails;
	
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "supplierId", nullable = false)
	private Suppliers supplierId;
	
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "serviceId", nullable = false)
	private Services serviceId;
	
	
	
	//getter...
	@Column(length = 20)
	private double charges;

	public Integer getSupplierServiceId() {
		return supplierServiceId;
	}

	public void setSupplierServiceId(Integer supplierServiceId) {
		this.supplierServiceId = supplierServiceId;
	}

	public Set<Booking_Detof_Service_Suppliers> getSupplierserviceDetails() {
		return supplierserviceDetails;
	}

	public void setSupplierserviceDetails(Set<Booking_Detof_Service_Suppliers> supplierserviceDetails) {
		this.supplierserviceDetails = supplierserviceDetails;
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

	@Override
	public String toString() {
		return "Supplier_Services [supplierServiceId=" + supplierServiceId + ", supplierserviceDetails="
				+ supplierserviceDetails + ", supplierId=" + supplierId + ", serviceId=" + serviceId + ", charges="
				+ charges + "]";
	}
	
	

	
	
	
	
}
