package com.app.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Facilities")
public class Facilities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer facilityId;

	
	@JsonIgnore
	//@JsonIgnoreProperties("facilityId")
	@OneToMany(mappedBy = "facilityId", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	private Set<VenueFacilities> venueFacilities;

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

	public Set<VenueFacilities> getVenueFacilities() {
		return venueFacilities;
	}

	public void setVenueFacilities(Set<VenueFacilities> venueFacilities) {
		this.venueFacilities = venueFacilities;
	}

	@Override
	public String toString() {
		return "Facilities [facilityId=" + facilityId + ", facilityName=" + facilityName + "]";
	}

	


}
