package com.app.pojos;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Facilities")
public class Facilities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer facilityId;

	@JsonIgnore
	@OneToMany(mappedBy = "facilityId", cascade = CascadeType.ALL)
	private Set<Venue_Facilities> Venue_Facilities;

	@Column(length = 30)
	private String facilityName;

	// getter
	public Integer getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	@Override
	public String toString() {
		return "Facilities [facilityId=" + facilityId + ", facilityName=" + facilityName + "]";
	}

}
