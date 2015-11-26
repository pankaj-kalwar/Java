package com.beyondalgo.java.immutablconcept;

public class MyMutable {
	private String name;
	private int age;

	public MyMutable() {
	}

	public MyMutable(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MyMutable [name=" + name + ", age=" + age + "]";
	}
}
