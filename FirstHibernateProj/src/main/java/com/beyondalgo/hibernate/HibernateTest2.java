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
		
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Car");
		
		// during one to one mapping
		//user1.setVehicle(vehicle);
		
		// during one to many mapping
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setName("Jeep");
		
		/*user1.setVehicle(vehicle);
		user1.setVehicle(vehicle2);*/
		user1.getVehicles().add(vehicle);
		vehicle.setUserDetails2(user1);
		user1.getVehicles().add(vehicle2);
		vehicle2.setUserDetails2(user1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Adding a data 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}
}
