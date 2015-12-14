package com.beyondalgo.hibernate.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.Configuration;

public class SecondLevelCaching {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		/** First Caching test */
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/** Save Operation */
		/*for (int i = 1; i <= 10; i++) {
			UserDetailsForCaching user = new UserDetailsForCaching();
			user.setName("User " + i);
			session.save(user);
		}*/
		
		System.out.println("\n\n -- Testing of second level cache");
		UserDetailsForSecondLevelCaching user11 = (UserDetailsForSecondLevelCaching) session.get(UserDetailsForSecondLevelCaching.class, 2);
		
		// Throws exception like, "java.lang.UnsupportedOperationException: Can't write to a readonly object"
		// when trying to update get object if Entity set to @Cache(usage=CacheConcurrencyStrategy.READ_ONLY) 
		// to make it work use "@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)"
		user11.setName("User 2 updated again and again");
		
		session.getTransaction().commit();
		session.close();
		
		/** Caching test */
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();

		UserDetailsForSecondLevelCaching user2 = (UserDetailsForSecondLevelCaching) session2.get(UserDetailsForSecondLevelCaching.class, 2);
		System.out.println("Updated user name = "+user2.getName());

		session2.getTransaction().commit();
		session2.close();
		
		System.out.println("terminating............");
		System.exit(0);
	}
}
