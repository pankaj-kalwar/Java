package com.beyondalgo.datastructures;

import java.util.Arrays;
import java.util.Stack;
 
 
public class StockSpanProblem {
 
    static void calculateSpan(int price[], int n, Integer[] s)
    {
        
       Stack<Integer> st = new  Stack<Integer>();
       st.push(0);
      
       s[0] = 1;
      
 
       for (int i = 1; i < n; i++)
       {
       
           while (!st.empty() && price[st.peek()] < price[i])
             st.pop();
      
          s[i] = (st.empty())? (i + 1) : (i - st.peek());
      
          st.push(i);
       }
    }
      
    static void printArray(Integer[] s, int n)
    {
        for (int i = 0; i < n; i++)
            if(i==n-1)
                System.out.print(s[i] +"]");
            else
                System.out.print(s[i] +", ");
    }
     
    public static void main(String[] args) {
 
        int price[] = {100, 80, 60, 70, 60, 75, 85};
        System.out.println("7 days prices of stack:" + Arrays.toString(price) );
         
         Integer []S = new Integer[price.length];
          
         calculateSpan(price, price.length, S );
          
         System.out.print("Print the calculated span values:[");
            printArray(S , price.length);
 
    }
 
}
