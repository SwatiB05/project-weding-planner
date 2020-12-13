package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name = "Booking_Detof_Service_Suppliers")
public class Booking_Detof_Service_Suppliers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "bookingId", nullable = false)
	private Bookings bookingId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "supplierServiceId", nullable = false)
	private Supplier_Services supplierServiceId;

	
	//geter...
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

	public Supplier_Services getSupplierServiceId() {
		return supplierServiceId;
	}

	public void setSupplierServiceId(Supplier_Services supplierServiceId) {
		this.supplierServiceId = supplierServiceId;
	}

	@Override
	public String toString() {
		return "Booking_Detof_Service_Suppliers [id=" + id + ", bookingId=" + bookingId + ", supplierServiceId="
				+ supplierServiceId + "]";
	}

	
	
	
}
