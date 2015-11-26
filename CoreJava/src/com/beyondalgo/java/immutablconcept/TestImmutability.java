package com.beyondalgo.java.immutablconcept;

import java.util.Date;

public class TestImmutability {
	public static void main(String[] args) {
		ImmutableClass im1 = new ImmutableClass(null, null, new Date(), new MyMutable());
		System.out.println(im1);
		im1.getMyMutableField().setAge(12);
		System.out.println(im1);
		
		
		ImmutableClass im = ImmutableClass.createNewInstance(100, "test", new Date(), new MyMutable("Pankaj", 25));
		System.out.println(im);
		im.getMyMutableField().setAge(29);
		System.out.println(im);
		tryModification(im.getImmutableField1(), im.getImmutableField2(), im.getMutableField(), im.getMyMutableField());
		System.out.println(im);
	}

	private static void tryModification(Integer immutableField1,
			String immutableField2, Date mutableField, MyMutable myMutable) {
		immutableField1 = 10000;
		immutableField2 = "test changed";
		mutableField.setDate(10);
		myMutable.setName("Pankaj111");
	}
}
