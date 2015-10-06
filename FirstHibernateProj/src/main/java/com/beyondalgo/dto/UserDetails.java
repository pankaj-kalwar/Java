package com.beyondalgo.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	
	//@EmbeddedId	
	private UserCompositeKey compositeKey;

	@Column(name = "user_name")
	private String name;

	@Column(name = "join_date")
	@Temporal(TemporalType.DATE)
	private Date joinDate;

	@Column(name = "description")
	@Lob
	private String description;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="city", column=@Column(name="home_city_name")),
		@AttributeOverride(name="state", column=@Column(name="home_state_name")),
		@AttributeOverride(name="pincode", column=@Column(name="home_pincode")),
		@AttributeOverride(name="street", column=@Column(name="home_street_name"))
	})
	private Address homeAddress;

	@Embedded
	private Address officeAddress;
	
	@ElementCollection//(fetch=FetchType.EAGER)
	@JoinTable(name="user_address", joinColumns=@JoinColumn(name="user_id"))
	//@Fetch(value = FetchMode.SELECT)
	/*private Set<Address> listOfAddress = new HashSet<Address>();*/
	
	/**
	 * to generate a id of embedded 
	 * 
	 */
	/*@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId(columns = { @Column(name="address_id") }, generator = "hilo-gen", type = @Type(type="long"))*/
	private Collection<Address> listOfAddress = new ArrayList<Address>();

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public UserCompositeKey getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(UserCompositeKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

}
