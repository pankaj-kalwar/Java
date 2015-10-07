package com.beyondalgo.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserCompositeKey implements Serializable{
	private static final long serialVersionUID = -6978684678444770450L;
	
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
