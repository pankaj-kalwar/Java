package com.beyondalgo.java.springrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.beyondalgo.java.springrest.models.Employee;
import com.beyondalgo.java.springrest.services.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String testMethod(){
		return "Test Data";
	}
	
	@RequestMapping(value="/getEmployees", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		employees = employeeService.findAllEmployees();
		System.out.println("employees === "+employees);
		if(employees.isEmpty()){
			//You many decide to return HttpStatus.NOT_FOUND
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	//-------------------Retrieve Single Employee--------------------------------------------------------
    
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        System.out.println("Fetching Employee with id " + id);
        Employee employee = employeeService.findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Employee--------------------------------------------------------
     
    @RequestMapping(value = "/employee/", method = RequestMethod.POST)
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Employee " + employee.getName());
 
        employeeService.saveEmployee(employee);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
     
    //------------------- Update a Employee --------------------------------------------------------
     
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        System.out.println("Updating Employee " + id);
         
        Employee currentEmployee = employeeService.findEmployeeById(id);
         
        if (currentEmployee==null) {
            System.out.println("Employee with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
 
        currentEmployee.setName(employee.getName());
        currentEmployee.setSalary(employee.getSalary());
         
        employeeService.updateEmployee(currentEmployee);
        return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
    }
 
    //------------------- Delete a Employee --------------------------------------------------------
     
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Employee with id " + id);
 
        Employee employee = employeeService.findEmployeeById(id);
        if (employee == null) {
            System.out.println("Unable to delete. Employee with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
 
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
}
