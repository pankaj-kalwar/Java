package com.beyondalgo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	/*@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserDetails2 userDetails2;*/
	
	// For Many to many 
	/*@ManyToMany(mappedBy="vehicles")
	private Collection<UserDetails2> userDetailsList = new ArrayList<UserDetails2>();*/

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

	/*public Collection<UserDetails2> getUserDetailsList() {
		return userDetailsList;
	}

	public void setUserDetailsList(Collection<UserDetails2> userDetailsList) {
		this.userDetailsList = userDetailsList;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;		
		return true;
	}

	
	/*public UserDetails2 getUserDetails2() {
		return userDetails2;
	}

	public void setUserDetails2(UserDetails2 userDetails2) {
		this.userDetails2 = userDetails2;
	}*/
	
}
