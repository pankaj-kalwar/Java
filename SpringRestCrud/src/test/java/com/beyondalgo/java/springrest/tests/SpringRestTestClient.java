package com.beyondalgo.java.springrest.tests;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

public class SpringRestTestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/SpringRestCrud";
	
	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllUsers(){
		System.out.println("Testing ListAllEmployees API-----------");
		
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> employeeMap = restTemplate.getForObject(REST_SERVICE_URI+"/getEmployees/", List.class);
		
		if(employeeMap!=null){
			for(LinkedHashMap<String, Object> map : employeeMap){
	            System.out.println("User : id="+map.get("id")+", Name="+map.get("name"));;
	        }
		}else{
			System.out.println("No Employee exist----------");
		}
	}
	
	

    public static void main(String args[]){
		listAllUsers();
    }
}
