package com.beyondalgo.java.petshop.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.beyondalgo.java.petshop.models.Category;

@Repository
public class CategoryDaoImpl extends AbstractDao implements CategoryDao{

	public void saveCategory(Category category) {
		persist(category);
	}

	@SuppressWarnings("unchecked")
	public List<Category> findAllCategories() {
		/*Criteria criteria = getSession().createCriteria(Employee.class);
		return (List<Employee>) criteria.list();*/
		return getSession().createQuery("from Category e").list();
	}

	public Category findCategoryById(int id) {
		return (Category) getSession().get(Category.class, id);
	}

	public void deleteCategory(Category category) {
		getSession().delete(category);
	}

	public void updateCategory(Category category) {
		getSession().update(category);
	}

	/*public Employee findBySsn(String ssn) {
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Employee) criteria.uniqueResult();
	}*/
}
