package com.beyondalgo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserDetails2 userDetails2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserDetails2 getUserDetails2() {
		return userDetails2;
	}

	public void setUserDetails2(UserDetails2 userDetails2) {
		this.userDetails2 = userDetails2;
	}

}
