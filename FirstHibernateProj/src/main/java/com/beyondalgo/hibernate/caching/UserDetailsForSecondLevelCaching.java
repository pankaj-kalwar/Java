package com.beyondalgo.hibernate.caching;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="User_Details_For_Query")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY) // makes cache only in read mode. ..if tying to update gives exception
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) // makes cache both read as well as write
@Cacheable
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
