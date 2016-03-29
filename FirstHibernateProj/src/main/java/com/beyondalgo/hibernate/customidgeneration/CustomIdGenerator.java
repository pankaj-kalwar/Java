package com.beyondalgo.hibernate.customidgeneration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CustomIdGenerator {
	
	@Id
	@GenericGenerator(name="seq_id", strategy="com.beyondalgo.hibernate.customidgeneration.MyIdGenerator")
	@GeneratedValue(generator="seq_id")
	private String id;
	
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
