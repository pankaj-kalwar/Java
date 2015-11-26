package com.beyondalgo.hibernate.inheritanceExample;

import javax.persistence.Entity;

@Entity

/**
 * Only used during single table strategy*/
//@DiscriminatorValue(value="Bike")
public class TwoWheeler extends VehicleForInheritance {
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
