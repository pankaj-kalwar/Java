package com.beyondalgo.hibernate.crudExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateStateExample {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		/** Transient State */
		// At this moment the user object in transient state
		UserDetailsForCrud user = new UserDetailsForCrud();
		user.setName("Transient Data Name");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//By using session.save() ... making user object from transient to persistent
		user.setName("Object before save");
		/**  Persistent State */
		session.save(user);
		
		// After saving an object it enters into persistent state. Therefore even after changing the object data, it will
		// reflected into database as it is in persistent state till the session is not closed.
		user.setName("Object After save");

		session.getTransaction().commit();
		session.close();
		
		/**  Detached State */
		// After the session is closed .. user object has Detached state
		user.setName("Object in detached state");
	}
}
