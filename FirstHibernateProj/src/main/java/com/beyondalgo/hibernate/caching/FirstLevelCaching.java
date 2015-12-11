package com.beyondalgo.hibernate.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCaching {
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
		
		System.out.println("\n\n -- Testing of first level cache");
		UserDetailsForCaching user11 = (UserDetailsForCaching) session.get(UserDetailsForCaching.class, 2);
		user11.setName("User 2 updated");
		
		UserDetailsForCaching user12 = (UserDetailsForCaching) session.get(UserDetailsForCaching.class, 2);
		System.out.println("name = "+user12.getName());
		
		session.getTransaction().commit();
		session.close();
		
		/** Caching test */
		/*Session session2 = sessionFactory.openSession();
		session2.beginTransaction();

		UserDetailsForCaching user2 = (UserDetailsForCaching) session2.get(UserDetailsForCaching.class, 2);

		session2.getTransaction().commit();
		session2.close();*/
		
		
		/** Clearing cache object with evict() Caching test */
		System.out.println("\n\n -- Clearing cache object with evict() Caching test ");
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		UserDetailsForCaching user21 = (UserDetailsForCaching) session2.get(UserDetailsForCaching.class, 2);
		
		session2.evict(user21);
		
		UserDetailsForCaching user22 = (UserDetailsForCaching) session2.get(UserDetailsForCaching.class, 2);
		
		session2.getTransaction().commit();
		session2.close();
		
		
		
		/** Clearing cache object with clear() Caching test */
		System.out.println("\n\n -- Clearing cache object with clear() Caching test ");
		Session session3 = sessionFactory.openSession();
		session3.beginTransaction();
		
		UserDetailsForCaching user31 = (UserDetailsForCaching) session3.get(UserDetailsForCaching.class, 2);
		
		session3.clear();
		
		UserDetailsForCaching user32 = (UserDetailsForCaching) session3.get(UserDetailsForCaching.class, 2);
		
		session3.getTransaction().commit();
		session3.close();

	}
}
