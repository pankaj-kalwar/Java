package com.beyondalgo.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/*@Entity
 @Table(name = "Address")*/
@Embeddable
public class Address {
	@Column(name = "city_name")
	private String city;
	@Column(name = "state_name")
	private String state;
	@Column(name = "pincode")
	private String pincode;
	@Column(name = "street_name")
	private String street;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
