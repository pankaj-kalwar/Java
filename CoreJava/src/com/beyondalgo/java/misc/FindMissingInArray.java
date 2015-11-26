package com.beyondalgo.java.misc;

public class FindMissingInArray {
	public static void main(String[] args) {
		
		int arr[] = {1,3,4,6,8,5,2,0,9,10};
		
		int sum = 0;
		int idx = -1;
		for (int i = 0; i < arr.length; i++)
		{
		    if (arr[i] == 0)
		    {
		         idx = i; 
		    }
		    else 
		    {
		         sum += arr[i];
		    }
		}

		// the total sum of numbers between 1 and arr.length.
		System.out.println("arr.length == "+arr.length);
		
		int total = (arr.length) * (arr.length+1) / 2;
		System.out.println("Total = "+total);
		System.out.println("Sum = "+sum);

		System.out.println("missing number is: " + (total - sum) + " at index " + idx);

	}
}
