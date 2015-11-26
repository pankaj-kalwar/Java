package com.beyondalgo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beyondalgo.dto.UserDetails2;
import com.beyondalgo.dto.Vehicle;

public class HibernateTest2 {
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		UserDetails2 user1 = new UserDetails2();
		user1.setName("First User");
		
		UserDetails2 user2 = new UserDetails2();
		user1.setName("Second User");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Car");
		
		// during one to one mapping
		//user1.setVehicle(vehicle);
		
		// during one to many mapping
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setName("Jeep");
		
		/*user1.setVehicle(vehicle);
		user1.setVehicle(vehicle2);*/
		
		// For One to many & many to one example 
		/*user1.getVehicles().add(vehicle);
		vehicle.setUserDetails2(user1);
		user1.getVehicles().add(vehicle2);
		vehicle2.setUserDetails2(user1);*/
		
		// For Many to any Example
		/*user1.getVehicles().add(vehicle);
		user1.getVehicles().add(vehicle2);
		//user2.getVehicles().add(vehicle);
		
		vehicle.getUserDetailsList().add(user1);
		vehicle.getUserDetailsList().add(user2);
		vehicle2.getUserDetailsList().add(user1);*/
		
		// For one to many with cascade
		user1.getVehicles().add(vehicle);
		user1.getVehicles().add(vehicle2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Adding a data 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user1);
		
		// When using cascade than you don't need to save child entity. It will automatically save it to DB
		/*session.save(user2);
		session.save(vehicle);
		session.save(vehicle2);*/
		
		
		
		session.getTransaction().commit();
		session.close();
	}
}
