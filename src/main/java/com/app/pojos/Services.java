package com.app.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Services")
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer serviceId;

	@JsonIgnore
	//@JsonIgnoreProperties("serviceId")
	@OneToMany(mappedBy = "serviceId", cascade = CascadeType.ALL)
	private Set<SupplierServices> supplierServices;

	@Column(length = 30)
	private String serviceName;


	//getter setters
	public Integer getServiceId() {
		return serviceId;
	}


	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public Set<SupplierServices> getSupplierServices() {
		return supplierServices;
	}


	public void setSupplierServices(Set<SupplierServices> supplierServices) {
		this.supplierServices = supplierServices;
	}


	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", serviceName=" + serviceName + "]";
	}


	


}
