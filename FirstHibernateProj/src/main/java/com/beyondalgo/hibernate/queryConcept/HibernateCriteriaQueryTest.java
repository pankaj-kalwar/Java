package com.beyondalgo.hibernate.queryConcept;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;

public class HibernateCriteriaQueryTest {
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

		/** Criteria Query Operation */
		System.out.println("\n\n--Criteria Query without restriction");
		Criteria criteria = session.createCriteria(UserDetailsForQuery.class);
		System.out.println(criteria.list());
		
		
		System.out.println("\n\n--Criteria Query with restriction");
		Criteria criteria1 = session.createCriteria(UserDetailsForQuery.class);
		criteria1.add(Restrictions.eq("name", "User 10"));
		System.out.println(criteria1.list());
		
		System.out.println("\n\n--Criteria Query with multiple restrictions");
		Criteria criteria2 = session.createCriteria(UserDetailsForQuery.class);
		criteria2.add(Restrictions.like("name", "User 1%"))
				.add(Restrictions.between("id", 5, 10));
		System.out.println(criteria2.list());
		
		// as adding multiple restrictions makes the condition following "and"
		// so to make "or" conditions
		
		System.out.println("\n\n--Criteria Query with multiple 'OR' restrictions");
		Criteria criteria3 = session.createCriteria(UserDetailsForQuery.class);
		criteria3.add(Restrictions.or(
							Restrictions.like("name", "User 1%"), 
							Restrictions.between("id", 5, 10)
					));
		System.out.println(criteria3.list());
		
		// Define more than two or conditions
		System.out.println("\n\n--Criteria Query with more than 2 'OR' restrictions");
		Criteria criteria4 = session.createCriteria(UserDetailsForQuery.class);
		criteria4.add(Restrictions.or(
							Restrictions.or(
								Restrictions.like("name", "User 1%"), 
								Restrictions.between("id", 8, 10)
							),
							Restrictions.between("id", 3, 5)
					));
		System.out.println(criteria4.list());
		
		// Define more than two or conditions using disjunction method
		System.out.println("\n\n--Criteria Query with more than 2 'OR' restrictions using disjunction");
		Criteria criteria5 = session.createCriteria(UserDetailsForQuery.class);
		Junction conditionGroup = Restrictions.disjunction();
		conditionGroup.add(Restrictions.like("name", "User 1%"))
					   .add(Restrictions.between("id", 8, 10))
					   .add(Restrictions.between("id", 3, 5));
		
		criteria5.add(conditionGroup);
		
		System.out.println(criteria5.list());
		
		
		session.getTransaction().commit();
		session.close();
	}
}
