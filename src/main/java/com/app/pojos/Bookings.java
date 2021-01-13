package com.app.pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Bookings")
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;

	// @JsonIgnore
	@JsonIgnoreProperties("bookings")
	@ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY,targetEntity = VenueFacilities.class)
	@Fetch(FetchMode.JOIN)
	@JoinTable(name = "BookingVenueFacilities", joinColumns = @JoinColumn(name = "bookingId"), inverseJoinColumns = @JoinColumn(name = "venueFacilityId"))
	private Set<VenueFacilities> venueFacilityDetails=new HashSet<VenueFacilities>();

	// @JsonIgnore
	@JsonIgnoreProperties("bookings")
	@ManyToMany(targetEntity = SupplierServices.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL)@Fetch(FetchMode.JOIN)
	@JoinTable(name = "BookingServiceSuppliers", joinColumns = @JoinColumn(name = "bookingId"), inverseJoinColumns = @JoinColumn(name = "supplierServiceId"))
	private Set<SupplierServices> serviceSupplierDetails=new HashSet<SupplierServices>();

	@Column(length = 15)
	private String bookingName;

	@ManyToOne
	@JsonIgnoreProperties("bookings")
	@JoinColumn(name = "customerId", nullable = false)
	private Customers customerId;

	@Column(length = 15)
	private Double totalAmount;

	@Column(length = 10)
	private Double discount;

	@Temporal(TemporalType.DATE)
	@Column(columnDefinition = "DATE default (CURRENT_DATE)")
	@CreatedDate
	@JsonFormat(pattern="dd-MM-yyyy")
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

	public Set<SupplierServices> getServiceSupplierDetails() {
		return serviceSupplierDetails;
	}

	public void setServiceSupplierDetails(Set<SupplierServices> serviceSupplierDetails) {
		this.serviceSupplierDetails = serviceSupplierDetails;
	}

	public Set<VenueFacilities> getVenueFacilityDetails() {
		return venueFacilityDetails;
	}

	public void setVenueFacilityDetails(Set<VenueFacilities> venueFacilityDetails) {
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
