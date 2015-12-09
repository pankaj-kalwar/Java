package com.beyondalgo.java.springrest.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beyondalgo.java.springrest.daos.EmployeeDAO;
import com.beyondalgo.java.springrest.models.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	public List<Employee> findAllEmployees() {
		return employeeDao.findAllEmployees();
	}
	
	public Employee findEmployeeById(int id){
		return employeeDao.findEmployeeById(id);
	}

	public void deleteEmployeeBySsn(String ssn) {
		employeeDao.deleteEmployeeBySsn(ssn);
	}
	
	 public void deleteEmployeeById(int id){
		 employeeDao.deleteEmployeeById(findEmployeeById(id));
	 }

	public Employee findBySsn(String ssn) {
		return employeeDao.findBySsn(ssn);
	}

	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

}
