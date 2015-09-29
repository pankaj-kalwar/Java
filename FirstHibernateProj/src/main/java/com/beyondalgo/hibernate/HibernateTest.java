package com.beyondalgo.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beyondalgo.dto.UserDetails;

public class HibernateTest {
	
	
	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		//user1.setId(1);
		user1.setName("First User");
		user1.setJoinDate(new Date());
		user1.setAddress("Thane");
		user1.setDescription("Desc 1");
		
		UserDetails user2 = new UserDetails();
		//user2.setId(2);
		user2.setName("Second User");
		user2.setJoinDate(new Date());
		user2.setAddress("Thane2");
		user2.setDescription("Desc 2");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// Adding a data 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user1 = null;
		// Fetching a data 
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*user1 = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User Name = "+user1.getName());*/
		
	}
}
