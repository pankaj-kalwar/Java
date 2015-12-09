package com.beyondalgo.java.springrest.daos;

import java.util.List;

import com.beyondalgo.java.springrest.models.Employee;

public interface EmployeeDAO {
	void saveEmployee(Employee employee);
    
    List<Employee> findAllEmployees();
    
    Employee findEmployeeById(int id);
    
    void deleteEmployeeBySsn(String ssn);
    
    void deleteEmployeeById(Employee employee);
     
    Employee findBySsn(String ssn);
     
    void updateEmployee(Employee employee);
}
