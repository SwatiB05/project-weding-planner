package com.app.pojos;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Services")
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer serviceId;

	@JsonIgnore
	@OneToMany(mappedBy = "serviceId", cascade = CascadeType.ALL)
	private Set<Supplier_Services> Supplier_Services;

	@Column(length = 30)
	private String serviceName;

	
	//getter....
	public Integer getServiceId() {
		return serviceId;
	}

	// getter..
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", serviceName=" + serviceName + "]";
	}

}
