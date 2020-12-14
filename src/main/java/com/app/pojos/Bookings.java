package com.app.pojos;



import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Bookings")
public class Bookings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	
	
	@JsonManagedReference
    @JsonIgnore
	@OneToMany(mappedBy = "bookingId",cascade = CascadeType.ALL)
	private Set<Booking_Detof_Venue_Facilities> venueFacilityDetails;
	
	
	@JsonManagedReference
    @JsonIgnore
	@OneToMany(mappedBy = "bookingId",cascade = CascadeType.ALL)
	private Set<Booking_Detof_Service_Suppliers> serviceSupplierDetails;
	
	
	@Column(length = 15)
	private String bookingName;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "customerId", nullable = false)
	@JsonBackReference
	private Customers customerId;
	
	@Column(length = 15)
	private double totalAmount;
	
	@Column(length = 10)
	private double discount;
	
	
	@Temporal(TemporalType.DATE)
	@Column(columnDefinition="DATE default (CURRENT_DATE)")
	@CreatedDate
	@JsonProperty(value = "Date-Of-Booking")
	private Date dateOfBooking;


	
	//getter setter
	
	public Integer getBookingId() {
		return bookingId;
	}


	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}


	public Set<Booking_Detof_Venue_Facilities> getVenueFacilityDetails() {
		return venueFacilityDetails;
	}


	public void setVenueFacilityDetails(Set<Booking_Detof_Venue_Facilities> venueFacilityDetails) {
		this.venueFacilityDetails = venueFacilityDetails;
	}


	public Set<Booking_Detof_Service_Suppliers> getServiceSupplierDetails() {
		return serviceSupplierDetails;
	}


	public void setServiceSupplierDetails(Set<Booking_Detof_Service_Suppliers> serviceSupplierDetails) {
		this.serviceSupplierDetails = serviceSupplierDetails;
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


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public Date getDateOfBooking() {
		return dateOfBooking;
	}


	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}


	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", venueFacilityDetails=" + venueFacilityDetails
				+ ", serviceSupplierDetails=" + serviceSupplierDetails + ", bookingName=" + bookingName
				+ ", customerId=" + customerId + ", totalAmount=" + totalAmount + ", discount=" + discount
				+ ", dateOfBooking=" + dateOfBooking + "]";
	}

	
	
	
	
	
}
