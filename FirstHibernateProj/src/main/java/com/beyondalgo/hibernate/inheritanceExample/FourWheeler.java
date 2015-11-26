package com.beyondalgo.hibernate.inheritanceExample;

import javax.persistence.Entity;

@Entity

/**
 * Only used during single table strategy*/
//@DiscriminatorValue(value="Car")
public class FourWheeler extends VehicleForInheritance {
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}
