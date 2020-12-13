package com.app.pojos;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="Venues")
public class Venues {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer venueId;
	
	

	@OneToMany(mappedBy = "venueId",cascade = CascadeType.ALL)
	private Set<Venue_Facilities> Venue_Facilities;
	
	
	
	@Column(length = 30)
	private String venueName;
	
	@Column(length = 60)
	private String venueAddress;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "cityId", nullable = false)
	private Venues cityId;;
	
	@Column(length = 10)
	private String phoneNo;
	
	@Column(length = 20)
	private String email;
	
	@Column(length = 100)
	private String image;
	
	@Column(length = 20)
	private Integer guestCapacity;
	
	@Column(length = 100)
	private String description;

	
	
	//getters and setters
	public Integer getVenueId() {
		return venueId;
	}

	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}

	public Set<Venue_Facilities> getVenue_Facilities() {
		return Venue_Facilities;
	}

	public void setVenue_Facilities(Set<Venue_Facilities> venue_Facilities) {
		Venue_Facilities = venue_Facilities;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueAddress() {
		return venueAddress;
	}

	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}

	public Venues getCityId() {
		return cityId;
	}

	public void setCityId(Venues cityId) {
		this.cityId = cityId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getGuestCapacity() {
		return guestCapacity;
	}

	public void setGuestCapacity(Integer guestCapacity) {
		this.guestCapacity = guestCapacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Venues [venueId=" + venueId + ", Venue_Facilities=" + Venue_Facilities + ", venueName=" + venueName
				+ ", venueAddress=" + venueAddress + ", cityId=" + cityId + ", phoneNo=" + phoneNo + ", email=" + email
				+ ", image=" + image + ", guestCapacity=" + guestCapacity + ", description=" + description + "]";
	}
	

	

	
	
	
}