package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name = "Booking_Detof_Venue_Facilities")
public class Booking_Detof_Venue_Facilities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "bookingId", nullable = false)
	private Bookings bookingId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "venueFacilityId", nullable = false)
	private Venue_Facilities venueFacilityId;

	
	//getters..
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bookings getBookingId() {
		return bookingId;
	}

	public void setBookingId(Bookings bookingId) {
		this.bookingId = bookingId;
	}

	public Venue_Facilities getVenueFacilityId() {
		return venueFacilityId;
	}

	public void setVenueFacilityId(Venue_Facilities venueFacilityId) {
		this.venueFacilityId = venueFacilityId;
	}

	@Override
	public String toString() {
		return "Booking_Detof_Venue_Facilities [id=" + id + ", bookingId=" + bookingId + ", venueFacilityId="
				+ venueFacilityId + "]";
	}

	
	
	
}
