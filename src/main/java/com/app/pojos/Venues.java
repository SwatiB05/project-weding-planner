package com.app.pojos;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Venues")
public class Venues {

	@Id
	//@JsonManagedReference
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer venueId;


	//@JsonIgnore
	@JsonIgnoreProperties("venueId")
	@OneToMany(mappedBy = "venueId", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	private Set<VenueFacilities> venueFacilities;

	@Column(length = 30)
	private String venueName;

	@Column(length = 60)
	private String venueAddress;


	@ManyToOne
	@Basic(optional = true)
	@JsonIgnoreProperties("venues")
	@JoinColumn(name = "cityId",nullable = false)
	private Cities vcityId;

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

	// getters and setters
	public Integer getVenueId() {
		return venueId;
	}

	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
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

	public Cities getVcityId() {
		return vcityId;
	}

	public void setVcityId(Cities vcityId) {
		this.vcityId = vcityId;
	}

	public Set<VenueFacilities> getVenueFacilities() {
		return venueFacilities;
	}

	public void setVenueFacilities(Set<VenueFacilities> venueFacilities) {
		this.venueFacilities = venueFacilities;
	}

	@Override
	public String toString() {
		return "Venues [venueId=" + venueId + ", venueName=" + venueName + ", venueAddress=" + venueAddress
				+ ", vcityId=" + vcityId + ", phoneNo=" + phoneNo + ", email=" + email + ", image=" + image
				+ ", guestCapacity=" + guestCapacity + ", description=" + description + "]";
	}

	
	

}
