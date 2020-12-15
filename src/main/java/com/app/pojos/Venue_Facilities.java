package com.app.pojos;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "Venue_Facilities")
public class Venue_Facilities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer venueFacilityId;
	
	
	@JsonManagedReference(value="venueFacilityDetails")
    @JsonIgnoreProperties
	@ManyToMany(mappedBy = "venueFacilityDetails")
	private Set<Bookings> bookings;

    @JsonIgnoreProperties
	@JsonBackReference
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name = "venueId", nullable = false)
	private Venues venueId;
	
    
    @JsonIgnoreProperties
	@JsonBackReference
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
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

	public Set<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Venue_Facilities [venueFacilityId=" + venueFacilityId + ", bookings=" + bookings + ", venueId="
				+ venueId + ", facilityId=" + facilityId + ", charges=" + charges + "]";
	}

	
	

	
	

	
	
	
	
}
