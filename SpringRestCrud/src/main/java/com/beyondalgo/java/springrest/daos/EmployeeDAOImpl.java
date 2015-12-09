package com.beyondalgo.java.springrest.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beyondalgo.java.springrest.models.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl extends AbstractDao implements EmployeeDAO {

	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		/*Criteria criteria = getSession().createCriteria(Employee.class);
		return (List<Employee>) criteria.list();*/
		return getSession().createQuery("from Employee e").list();
	}
	
	public Employee findEmployeeById(int id) {
		return (Employee) getSession().get(Employee.class, id);
	}

	public void deleteEmployeeBySsn(String ssn) {
		Query query = getSession().createSQLQuery(
				"delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}
	
	 public void deleteEmployeeById(Employee employee){
		getSession().delete(employee);
	 }

	public Employee findBySsn(String ssn) {
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Employee) criteria.uniqueResult();
	}

	public void updateEmployee(Employee employee) {
		getSession().update(employee);
	}

}
