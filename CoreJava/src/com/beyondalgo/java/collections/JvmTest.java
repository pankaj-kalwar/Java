package com.beyondalgo.java.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class JvmTest {
	public static void main(String[] args) {
		//System.out.println("JVM Test");
		/*Integer i = 15;//new Integer(15);
		Integer j = 15;//new Integer(15);
		
		System.out.println(i == j);
		
		String s = new String("PK");
		String s1 = s;
		String t = "PK";
		
		System.out.println(s1 == t);*/
		
		
		
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = new Employee("pk", 1);
		Employee employee1 = new Employee("pk1", 2);
		Employee employee2 = new Employee("pk", 1);
		
		employees.add(employee);
		employees.add(employee1);
		employees.add(employee2);
		
		System.out.println(employees);
		
		Set<Employee> setEmployee = new LinkedHashSet<Employee>(employees);
		
		System.out.println(setEmployee);
		
		HashMap<Employee, Employee> myMap = new HashMap<Employee, Employee>();

		for(Employee e : employees){
			System.out.println(e.hashCode());
			myMap.put(e, e);
		}
		
		System.out.println(myMap.size());
		
	}
}
