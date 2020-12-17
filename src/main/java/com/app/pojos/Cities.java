package com.app.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Cities")

public class Cities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;
	

   @JsonIgnore
	@OneToMany(mappedBy = "vcityId" ,cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Venues> venues;
	
  
    @JsonIgnore
	@OneToMany(mappedBy = "scityId" ,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Suppliers> suppliers;
	
	@OneToMany(mappedBy = "ccityId" ,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
	private Set<Customers> customers;
	
	@Column(length = 30)
	private String city;
	
	//getters...
	
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Set<Venues> getVenues() {
		return venues;
	}

	public void setVenues(Set<Venues> venues) {
		this.venues = venues;
	}

	public Set<Suppliers> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Set<Suppliers> suppliers) {
		this.suppliers = suppliers;
	}

	public Set<Customers> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customers> customers) {
		this.customers = customers;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Cities [cityId=" + cityId + ", venues=" + venues + ", suppliers=" + suppliers + ", customers="
				+ customers + ", city=" + city + "]";
	}

	
	
	
	
}
