package com.beyondalgo.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beyondalgo.dto.Address;
import com.beyondalgo.dto.UserCompositeKey;
import com.beyondalgo.dto.UserDetails;

public class HibernateTest {
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		//user1.setId(1);
		user1.setName("First User");
		user1.setJoinDate(new Date());
		user1.setDescription("Desc 1");
		
		/*UserDetails user2 = new UserDetails();
		//user2.setId(2);
		user2.setName("Second User");
		user2.setJoinDate(new Date());
		user2.setDescription("Desc 2");*/
		
		Address homeAddress = new Address();
		homeAddress.setCity("City name");
		homeAddress.setPincode("123456");
		homeAddress.setState("MH");
		homeAddress.setStreet("Street name");
		
		user1.setHomeAddress(homeAddress);
		
		Address officeAddress = new Address();
		officeAddress.setCity("City name");
		officeAddress.setPincode("123456");
		officeAddress.setState("MH");
		officeAddress.setStreet("Street name");
		
		user1.setOfficeAddress(officeAddress);
		// For composite key
		UserCompositeKey compositeKey = new UserCompositeKey();
		compositeKey.setFirstName("Pankaj");
		compositeKey.setLastName("Kalwar");
		
		user1.setCompositeKey(compositeKey);
		
		user1.getListOfAddress().add(officeAddress);
		user1.getListOfAddress().add(homeAddress);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// Adding a data 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user1);
		//session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user1 = null;
		// Fetching a data 
		session = sessionFactory.openSession();
		
		// using load method
		//user1 = (UserDetails) session.load(UserDetails.class, 2);
		user1 = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		
		//System.out.println("User Details Object = "+user1);
		System.out.println("User Address = "+user1.getListOfAddress());
		
	}
}
