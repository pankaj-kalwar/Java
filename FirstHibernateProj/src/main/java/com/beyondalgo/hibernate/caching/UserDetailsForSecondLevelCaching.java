package com.beyondalgo.hibernate.caching;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Details_For_Query")
public class UserDetailsForSecondLevelCaching{
	@Id
	@GeneratedValue
	private int id;
	private String name;

	public UserDetailsForSecondLevelCaching() {
	}

	public UserDetailsForSecondLevelCaching(int id, String name) {
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

	@Override
	public String toString() {
		return "UserDetailsForHQL [id=" + id + ", name=" + name + "]";
	}
}
