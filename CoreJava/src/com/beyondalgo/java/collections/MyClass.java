package com.beyondalgo.java.collections;

public class MyClass implements MyInterface, MyInterface2{

	@Override
	public void abc() {
		System.out.println("ABC");
	}
	
	public static void main(String[] args) {
		MyClass class1 = new MyClass();
		class1.abc();
	}

}
