package com.beyondalgo.java.springrest.services;

import java.util.List;

import com.beyondalgo.java.springrest.models.Employee;

public interface EmployeeService {
	void saveEmployee(Employee employee);
	 
    List<Employee> findAllEmployees();
    
    Employee findEmployeeById(int id);
 
    void deleteEmployeeBySsn(String ssn);
    
    void deleteEmployeeById(int id);
 
    Employee findBySsn(String ssn);
 
    void updateEmployee(Employee employee);
}
