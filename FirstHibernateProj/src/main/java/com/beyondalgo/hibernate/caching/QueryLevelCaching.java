package com.beyondalgo.hibernate.caching;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryLevelCaching {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		
		/** Session 1 */
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		/** Save Operation */
		/*
		 * for (int i = 1; i <= 10; i++) { UserDetailsForCaching user = new
		 * UserDetailsForCaching(); user.setName("User " + i);
		 * session.save(user); }
		 */

		System.out.println("\n\n -- Testing of Query level cache");
		
		Query query = session.createQuery("from UserDetailsForSecondLevelCaching user where id = 2" );
		query.setCacheable(true);
		List users = query.list();
		
		/*Query query2 = session.createQuery("from UserDetailsForSecondLevelCaching user where id = 2" );
		query2.setCacheable(true);
		users = query2.list();
		*/
		session.getTransaction().commit();
		session.close();
		
		/** Session 2 */
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		Query query2 = session2.createQuery("from UserDetailsForSecondLevelCaching user where id = 2" );
		query2.setCacheable(true);
		users = query2.list();
		
		session2.getTransaction().commit();
		session2.close();
	}
}
