package com.beyondalgo.hibernate.queryConcept;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

public class HibernateCriteriaProjectionQueryTest {
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

		/**
		 * Projections will not return any specific object.
		 * 
		 * as below if we trying to cast criteria.list() in List<UserDetails>,
		 * it will throw exception
		 * 
		 * */
		
		try{
			/** Projection query casting  */
			System.out.println("\n\n-- Projection with cast");
			
			Criteria criteria = session.createCriteria(UserDetailsForQuery.class);
			criteria.setProjection(Projections.max("name"));
			
			List<UserDetailsForQuery> userDetails = criteria.list(); 
			System.out.println(userDetails);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		/** Criteria Query with projection  */
		System.out.println("\n\n-- Projection with single property projection");
		
		Criteria criteria = session.createCriteria(UserDetailsForQuery.class);
		criteria.setProjection(Projections.property("name"));
		
		System.out.println(criteria.list());
		
		/**  Projection with max value*/
		System.out.println("\n\n-- Projection with max value");
		Criteria criteria2 = session.createCriteria(UserDetailsForQuery.class)
								.setProjection(Projections.max("id"));
		
		System.out.println(criteria2.list());
		
		/** changing order*/
		System.out.println("\n\n-- Changing Order");
		Criteria criteria3 = session.createCriteria(UserDetailsForQuery.class)
								.addOrder(Order.desc("name"));
		
		System.out.println(criteria3.list());
		
		/** Projection using Example
		 * 
		 * While using Example class during projection. two things to remember
		 * 1. it will consider primary key 
		 * 2. it will consider a filed with null values
		 * 
		 * */
		System.out.println("\n\n-- Projection using Example ");
		
		UserDetailsForQuery userDetailsForQuery = new UserDetailsForQuery();
		userDetailsForQuery.setId(5);
		//userDetailsForQuery.setName("User 10");
		
		Example example = Example.create(userDetailsForQuery);
		
		Criteria criteria4 = session.createCriteria(UserDetailsForQuery.class)
								.add(example);
		
		System.out.println(criteria4.list());
		
		
		session.getTransaction().commit();
		session.close();
	}
}
