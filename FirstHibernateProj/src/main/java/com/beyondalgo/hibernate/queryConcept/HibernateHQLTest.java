package com.beyondalgo.hibernate.queryConcept;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHQLTest {
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

		/** HQL Operation */
		
		/** ------ HQL Basic Opertion*/
		System.out.println("\n\n-- HQL Basic Opertion");
		
		Query query = session.createQuery("from UserDetailsForQuery");
		System.out.println(query.list());
		
		
		
		/**  ------ HQL Opertion with restrictions*/
		System.out.println("\n\n-- HQL Opertion with restrictions");
		
		Query query1 = session.createQuery("from UserDetailsForQuery");
		// retrieve the result after the specified number i.e. if 5 than row starts from 5 onwards i.e. start form 6
		query1.setFirstResult(0); 
		// Sets the max result outcome
		query1.setMaxResults(4);
		
		System.out.println(query1.list());
		
		
		
		/**  ------ HQL Operation with select keyword and selected columns  */
		System.out.println("\n\n-- HQL Operation with select keyword and selected columns");		
		
		Query query2 = session.createQuery("select name from UserDetailsForQuery");
		System.out.println(query2.list());
		
		//Query query3 = session.createQuery("select new list(u) from UserDetailsForQuery u");
		Query query3 = session.createQuery("select new map(id, name) from UserDetailsForQuery u");
		@SuppressWarnings("unchecked")
		List<Map<String, String>> userMap = (List<Map<String, String>>) query3.list(); 
		System.out.println(userMap);
		
		
		
		/** ------ HQL - way of binding parameters & preventing SQL injection*/
		System.out.println("\n\n -- HQL - way of binding parameters & preventing SQL injection");
		
		// With SQL Injection 
		System.out.println("// With SQL Injection ");
		String minUserId = "5 or 1=1";
		Query query4 = session.createQuery("from UserDetailsForQuery where id > "+minUserId);
		System.out.println(query4.list());
		
		// Preventing SQL Injection
		System.out.println("\n// With SQL Injection Prevention using position indicator");
		String userName = "user11 or 1=1";
		Query query5 = session.createQuery("from UserDetailsForQuery where name = ?");
		query5.setString(0, userName);
		System.out.println(query5.list());
		
		System.out.println("\n// With SQL Injection Prevention using place holder");
		String userName1 = "% or 1=1";
		Query query6 = session.createQuery("from UserDetailsForQuery where name like :userName");
		query6.setString("userName", userName1);
		System.out.println(query6.list());

		session.getTransaction().commit();
		session.close();
	}
}
