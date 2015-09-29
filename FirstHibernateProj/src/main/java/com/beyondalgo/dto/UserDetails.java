package com.beyondalgo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
// @Entity(name = "USER_DETAILS") // Using this will change the entity name as
// well i.e. while writing HQL you have to mentioned entity name
@Table(name = "USER_DETAILS")
// Using this only change the table name & not the entity name i.e. while
// writing HQL you have to use class name as the default entity name
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "user_id")
	private int id;

	@Column(name = "user_name")
	private String name;

	@Column(name = "join_date")
	@Temporal(TemporalType.DATE)
	private Date joinDate;

	@Column(name = "address")
	private String address;

	@Column(name = "description")
	@Lob
	private String description;

	public UserDetails() {
	}

	public UserDetails(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
