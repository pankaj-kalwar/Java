package com.beyondalgo.java.misc;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalValidations {
	public static void main(String[] args) {
		BigDecimal b = BigDecimal.valueOf(0);
		BigDecimal noZero = b.stripTrailingZeros();
		System.out.println("noZero = "+noZero);

		
		int scale = b.scale();
		System.out.println("scale = "+scale);
		
		int precision = b.precision();  
		System.out.println("precision = "+precision);
		
		System.out.println(b.compareTo(BigDecimal.ZERO) > 0);
		System.out.println(b.intValue() > 100);
		System.out.println("scale <= 2 -- "+(scale > 2));
		
		if(b != null && b.compareTo(BigDecimal.ZERO) < 0){
			System.out.println("negative");
		}else if(b.intValue() > 100){
			System.out.println("greater than 100");
		}else if(scale > 2){
			System.out.println("scale is greater than 2");
		}
		
		if(b != null && (b.compareTo(BigDecimal.ZERO) < 0 || b.intValue() > 100 || scale > 2)){
			System.out.println("ERRRR");
		}
		
		/*if (scale < 0) { // Adjust for negative scale
		    precision -= scale;
		    scale = 0;        
		}*/
	}
}
