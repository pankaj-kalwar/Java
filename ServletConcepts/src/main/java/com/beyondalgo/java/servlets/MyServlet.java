package com.beyondalgo.java.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet extends GenericServlet{
	private static final long serialVersionUID = -6852710667166310320L;

	public void init(){
		System.out.println("Init");
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service ");
	}
	
	public void destory(){
		System.out.println("destroyed");
	}

}
