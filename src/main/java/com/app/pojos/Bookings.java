package com.app.pojos;



import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Bookings")
public class Bookings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	
	
	 @JsonBackReference(value = "venueFacilityDetails")
	  @JsonIgnoreProperties 
	  @ManyToMany(cascade ={CascadeType.MERGE,CascadeType.PERSIST})
	  @JoinTable(name =
	  "Booking_Venue_Facilities",joinColumns=@JoinColumn(name="bookingId"),
	  inverseJoinColumns = @JoinColumn(name="venueFacilityId"))
	  private Set<Venue_Facilities> venueFacilityDetails;
	 
	
	
	@JsonBackReference(value="serviceSupplierDetails")
    @JsonIgnoreProperties
    @ManyToMany(cascade ={CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name = "Booking_Service_Suppliers",joinColumns=@JoinColumn(name="bookingId"),inverseJoinColumns = @JoinColumn(name="supplierServiceId"))
	private Set<Supplier_Services> serviceSupplierDetails;
    
    
	@Column(length = 15)
	private String bookingName;
	
	
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", nullable = false)
	@JsonBackReference
	@JsonIgnoreProperties
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
