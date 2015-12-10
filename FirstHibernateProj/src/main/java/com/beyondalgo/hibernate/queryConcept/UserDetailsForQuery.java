package com.beyondalgo.hibernate.queryConcept;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity

// For Named Query Test 
@NamedQueries(
	{
		@NamedQuery(name="UserDetails.byName", query = "from UserDetailsForQuery where name = ?"),
		@NamedQuery(name="UserDetails.byNoCondition", query = "from UserDetailsForQuery")
	}
)
@NamedNativeQuery(name = "UserDetails.byId", query = "select * from User_Details_For_Query where id = ?", resultClass=UserDetailsForQuery.class)
@Table(name="User_Details_For_Query")
public class UserDetailsForQuery {
	@Id
	@GeneratedValue
	private int id;
	private String name;

	public UserDetailsForQuery() {
	}

	public UserDetailsForQuery(int id, String name) {
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
