package com.beyondalgo.java.polymorphismconcept;

public class PolymorphismTest {
	
	public void method1(Object o){
		System.out.println("Object");
	}
	
	public void method1(double[] o){
		System.out.println("double[]");
	}
	
	/*public void method1(String o){
		System.out.println("String");
	}
	
	public void method1(Integer o){
		System.out.println("Integer");
	}
	
	public void method1(int o){
		System.out.println("int");
	}
	
	public void method1(char o){
		System.out.println("char");
	}
	
	public void method1(Character o){
		System.out.println("character");
	}
	
	public void method1(Boolean o){
		System.out.println("Boolean");
	}
	
	public void method1(Byte o){
		System.out.println("Byte");
	}*/
	
	
	public static void main(String[] args) {
		PolymorphismTest test = new PolymorphismTest();
		//test.method1(0);
		
		double[] a = null;
		
		
		test.method1(null);
	}
}
