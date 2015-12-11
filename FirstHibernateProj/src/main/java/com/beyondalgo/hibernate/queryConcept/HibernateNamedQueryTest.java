package com.beyondalgo.hibernate.queryConcept;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateNamedQueryTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		/** Save Operation */

		for (int i = 1; i <= 10; i++) {
			UserDetailsForQuery user = new UserDetailsForQuery();
			user.setName("User " + i);
			session.save(user);
		}

		/** Named Query Operation */
		System.out.println("\n\n // By using named query without condition");
		Query query1 = session.getNamedQuery("UserDetails.byNoCondition");
		System.out.println(query1.list());
		
		System.out.println("\n\n // By using named query with condition");		
		String userName = "User 10";
		Query query2 = session.getNamedQuery("UserDetails.byName");
		query2.setString(0, userName);
		System.out.println(query2.list());
		
		System.out.println("\n\n // By using named native query with condition");		
		Query query3 = session.getNamedQuery("UserDetails.byId");
		query3.setInteger(0, 1);
		System.out.println(query3.list());
		
		session.getTransaction().commit();
		session.close();
	}
}
