package com.app.pojos;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "Venue_Facilities")
public class Venue_Facilities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer venueFacilityId;
	
	
	@JsonManagedReference
    @JsonIgnore
	@OneToMany(mappedBy = "venueFacilityId",cascade = CascadeType.ALL)
	private Set<Booking_Detof_Venue_Facilities> venueFacilityDetails;

	
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "venueId", nullable = false)
	private Venues venueId;
	
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "facilityId", nullable = false)
	private Facilities facilityId;
	
	@Column(length = 20)
	private double charges;

	
	
	//getter..
	public Integer getVenueFacilityId() {
		return venueFacilityId;
	}

	public void setVenueFacilityId(Integer venueFacilityId) {
		this.venueFacilityId = venueFacilityId;
	}

	public Set<Booking_Detof_Venue_Facilities> getVenueFacilityDetails() {
		return venueFacilityDetails;
	}

	public void setVenueFacilityDetails(Set<Booking_Detof_Venue_Facilities> venueFacilityDetails) {
		this.venueFacilityDetails = venueFacilityDetails;
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

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	@Override
	public String toString() {
		return "Venue_Facilities [venueFacilityId=" + venueFacilityId + ", venueFacilityDetails=" + venueFacilityDetails
				+ ", venueId=" + venueId + ", facilityId=" + facilityId + ", charges=" + charges + "]";
	}

	
	
	

	
	

	
	
	
	
}
