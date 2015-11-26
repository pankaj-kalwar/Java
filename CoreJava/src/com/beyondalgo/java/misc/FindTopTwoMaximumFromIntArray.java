package com.beyondalgo.java.misc;

/**
 * Question : Java Program To Find Top Two Maximum Numbers from Integer Array
		a.	You can not use any sorting functions and you should iterate the array only once. 
		b. Use of any kind of collection class e.g. TreeSet or LinkedHashSet are also not allowed. 
		For example, 
		
		if given integer array is [20, 34, 21, 87, 92, 2147483647] then first maximum is 2147483647 
		and second maximum is 92.
 * */

public class FindTopTwoMaximumFromIntArray {
	public static void main(String[] args) {
		findMaxTwo(new int[]{1, 4, 8, 10, 3, 2});
		
		//System.out.println(Integer.MAX_VALUE);
	}
	
	public static void findMaxTwo(int[] intArr){
		int tempNum = 0;
		int firstMax = 0;
		int secondMax = 0;
		for(int i = 0; i<intArr.length; i++){
			tempNum = intArr[i];			
			if(tempNum > firstMax){	
				secondMax = firstMax;
				firstMax = tempNum;
			}else if(tempNum > secondMax){
				secondMax = tempNum;
			}
		}
		System.out.println(firstMax);
		System.out.println(secondMax);
	}
}
