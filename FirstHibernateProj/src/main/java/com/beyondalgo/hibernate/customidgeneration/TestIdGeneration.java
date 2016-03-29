package com.beyondalgo.hibernate.customidgeneration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class TestIdGeneration {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		CustomIdGenerator customer = new CustomIdGenerator();
		customer.setName("pk");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// Adding a data 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(customer);
		//session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		
	}
}
