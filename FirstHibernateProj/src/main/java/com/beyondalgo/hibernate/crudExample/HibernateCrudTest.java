package com.beyondalgo.hibernate.crudExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCrudTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/** Save Operation */
		/*for (int i = 0; i < 10; i++) {
			UserDetailsForCrud user = new UserDetailsForCrud();
			user.setName("User "+i);
			session.save(user);
		}*/
		
		/** Retrieval (get or load) Operation */
		//UserDetailsForCrud user = (UserDetailsForCrud) session.load(UserDetailsForCrud.class, 1);
		UserDetailsForCrud user = (UserDetailsForCrud) session.get(UserDetailsForCrud.class, 1);
		System.out.println("User Name = "+user);
		
		/** Update Operation */
		/*user.setName("Updated1 Name");
		session.saveOrUpdate(user);*/
		
		
		/** Delete Operation */
		/*session.delete(user);*/
		
		
		session.getTransaction().commit();
		session.close();
	}
}
