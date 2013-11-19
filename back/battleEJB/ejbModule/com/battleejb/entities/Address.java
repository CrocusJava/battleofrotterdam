package entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = -8819095550566162411L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String district;
	private String street;
	private String houseNumber;
	private String apartment;
	
	@OneToOne(mappedBy = "address")
	@Basic (fetch = FetchType.LAZY) 
	private User user;	
	
	public Address(){}	

	public Address(Long id, String district, String street, String houseNumber,
			String apartment) {
		super();
		this.id = id;
		this.district = district;
		this.street = street;
		this.houseNumber = houseNumber;
		this.apartment = apartment;
	}
	
	public Address(Long id, String district, String street, String houseNumber,
			String apartment, User user) {
		this(id, district, street, houseNumber, apartment);
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apartment == null) ? 0 : apartment.hashCode());
		result = prime * result
				+ ((district == null) ? 0 : district.hashCode());
		result = prime * result
				+ ((houseNumber == null) ? 0 : houseNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		if (apartment == null) {
			if (other.apartment != null)
				return false;
		} else if (!apartment.equals(other.apartment))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (houseNumber == null) {
			if (other.houseNumber != null)
				return false;
		} else if (!houseNumber.equals(other.houseNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", district=");
		builder.append(district);
		builder.append(", street=");
		builder.append(street);
		builder.append(", houseNumber=");
		builder.append(houseNumber);
		builder.append(", apartment=");
		builder.append(apartment);
		builder.append("]");
		return builder.toString();
	}

	
	
}
