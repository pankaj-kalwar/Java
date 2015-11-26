package com.beyondalgo.java.polymorphismconcept;

import java.io.IOException;

public class ChildClass extends ParentClass{
	/**
	 * Return type should be same for overridden methods 
	 * As it shows compile time error i.e. incompatibale return type  
	 * 
	 * 
	 * Also the throws exception should be same as the parent one 
	 * or parent exception should be higher than the child one. like IOException parent class is Exception 
	 * 
	 * public void myMethod() throws Exception{ // give compile time error
	 * @throws Exception 
	 */
	
	/*public int myMethod(){
		System.out.println("In Child Method");
	}*/
	
	public void myMethod() throws Exception{
		System.out.println("in child method");
		throw new IOException();
	}
	
	public static void main(String[] args) {
		ParentClass parentClass = new ChildClass();
		try {
			parentClass.myMethod();
		} catch (IOException e) {
			System.out.println("Throws IOException");
		}catch (Exception e) {
			System.out.println("Throws Exception");
		}
	}
}
