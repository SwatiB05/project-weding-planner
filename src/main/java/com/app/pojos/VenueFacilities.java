package com.app.pojos;

import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "VenueFacilities")
public class VenueFacilities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer venueFacilityId;

	//@JsonIgnore
		@JsonIgnoreProperties("venueFacilityDetails")
		@ManyToMany( mappedBy = "venueFacilityDetails", 
		targetEntity = Bookings.class,fetch = FetchType.EAGER,
		cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
		private Set<Bookings> bookings;

	@ManyToOne
	//@JsonBackReference
	@JsonIgnoreProperties("enueFacilities")
	@JoinColumn(name = "venueId", nullable = false)
	private Venues venueId;

	@ManyToOne
	@JsonIgnoreProperties("venueFacilities")
	@JoinColumn(name = "facilityId", nullable = false)
	private Facilities facilityId;

	@Column(length = 20)
	private Double charges;

	// getter..
	public Integer getVenueFacilityId() {
		return venueFacilityId;
	}

	public void setVenueFacilityId(Integer venueFacilityId) {
		this.venueFacilityId = venueFacilityId;
	}

	public Venues getVenueId() {
		return venueId;
	}

	public void setVenueId(Venues venueId) {
		this.venueId = venueId;
	}

	public Facilities getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Facilities facilityId) {
		this.facilityId = facilityId;
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
		return "VenueFacilities [venueFacilityId=" + venueFacilityId + ", venueId=" + venueId + ", facilityId="
				+ facilityId + ", charges=" + charges + "]";
	}

	
}