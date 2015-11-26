package com.beyondalgo.hibernate.inheritanceExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateInheritanceTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		VehicleForInheritance vehicle = new VehicleForInheritance();
		vehicle.setName("Car");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setName("Bike");
		twoWheeler.setSteeringHandle("Bike handle");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setName("Porsche");
		fourWheeler.setSteeringWheel("Porsche Wheel");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Adding a data 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		
		
		session.getTransaction().commit();
		session.close();
	}
}
