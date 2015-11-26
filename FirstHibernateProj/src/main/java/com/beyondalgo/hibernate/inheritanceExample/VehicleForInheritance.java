package com.beyondalgo.hibernate.inheritanceExample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity

/** Single table inheritance is default & the discriminator is only used for this
 *  - Certain disadvantages like. its not in normalized form,    
 */
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="VEHICLE_TYPE",discriminatorType=DiscriminatorType.STRING)

/**
 *	To make it normalized we can use Inheritance type = Table per class
 *	- But the child table also has same column as in parent one
 */
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

/**
 * To make it more normalized we use JOINED inheritance type
 * - also for this type it's not required to give generation strategy as TABLE.. it accepts AUTO
 */
@Inheritance(strategy=InheritanceType.JOINED)

public class VehicleForInheritance {
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE) // It is only mandate for InheritanceType.TABLE_PER_CLASS
	@GeneratedValue
	private int id;
	private String name;

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
}
