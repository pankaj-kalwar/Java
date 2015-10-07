package com.beyondalgo.hibernate;

import java.net.MalformedURLException;
import java.net.URL;

public class Test {
	public static void main(String[] args) throws MalformedURLException {
		URL obj = new URL("http://www.javatppoint.com");
		System.out.println(obj.getPort());
	}
}