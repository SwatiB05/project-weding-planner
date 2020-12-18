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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Venue_Facilities")
public class Venue_Facilities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer venueFacilityId;

	@JsonIgnore
	@ManyToMany(mappedBy = "venueFacilityDetails")
	private Set<Bookings> bookings;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "venueId", nullable = false)
	private Venues venueId;

	@ManyToOne
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
		return "Venue_Facilities [venueFacilityId=" + venueFacilityId + ", bookings=" + bookings + ", venueId="
				+ venueId + ", facilityId=" + facilityId + ", charges=" + charges + "]";
	}

}
