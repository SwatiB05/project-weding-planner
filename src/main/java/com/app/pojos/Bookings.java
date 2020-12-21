package com.app.pojos;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Bookings")
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;


	@JsonIgnore
	@ManyToMany(cascade = {CascadeType.PERSIST, 
			CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},targetEntity = Venue_Facilities.class)
	@JoinTable(name = "Booking_Venue_Facilities", joinColumns = @JoinColumn(name = "bookingId"), inverseJoinColumns = @JoinColumn(name = "venueFacilityId"))
	private Set<Venue_Facilities> venueFacilityDetails;

	@JsonIgnore
	@ManyToMany(targetEntity = Supplier_Services.class,cascade = {CascadeType.PERSIST, 
			CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinTable(name = "Booking_Service_Suppliers", joinColumns = @JoinColumn(name = "bookingId"), inverseJoinColumns = @JoinColumn(name = "supplierServiceId"))
	private Set<Supplier_Services> serviceSupplierDetails;

	@Column(length = 15)
	private String bookingName;
	

	@ManyToOne
	@JoinColumn(name = "customerId",nullable = false)
	private Customers customerId;

	@Column(length = 15)
	private Double totalAmount;

	@Column(length = 10)
	private Double discount;

	@Temporal(TemporalType.DATE)
	@Column(columnDefinition = "DATE default (CURRENT_DATE)")
	@CreatedDate
	@JsonProperty(value = "DateOfBooking")
	private Date dateOfBooking;

	// getter setter

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingName() {
		return bookingName;
	}

	public void setBookingName(String bookingName) {
		this.bookingName = bookingName;
	}

	public Customers getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customers customerId) {
		this.customerId = customerId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public Set<Supplier_Services> getServiceSupplierDetails() {
		return serviceSupplierDetails;
	}

	public void setServiceSupplierDetails(Set<Supplier_Services> serviceSupplierDetails) {
		this.serviceSupplierDetails = serviceSupplierDetails;
	}

	public Set<Venue_Facilities> getVenueFacilityDetails() {
		return venueFacilityDetails;
	}

	public void setVenueFacilityDetails(Set<Venue_Facilities> venueFacilityDetails) {
		this.venueFacilityDetails = venueFacilityDetails;
	}

	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", venueFacilityDetails=" + venueFacilityDetails
				+ ", serviceSupplierDetails=" + serviceSupplierDetails + ", bookingName=" + bookingName
				+ ", customerId=" + customerId + ", totalAmount=" + totalAmount + ", discount=" + discount
				+ ", dateOfBooking=" + dateOfBooking + "]";
	}

}
