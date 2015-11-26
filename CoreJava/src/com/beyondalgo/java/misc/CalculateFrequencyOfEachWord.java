package com.beyondalgo.java.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * JAVA 8 Question -> calculate frequency of each word in a sentence
 * */

public class CalculateFrequencyOfEachWord {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the sentence");
		String text = br.readLine();
		text = text + " ";
		
		/*  By Using Java 7 */
		Map<Character, Integer> myMap = new HashMap<Character, Integer>();
		
		for (int i = 0; i < text.length(); i++) {
			if(myMap.containsKey(text.charAt(i))){
				myMap.put(text.charAt(i), myMap.get(text.charAt(i))+1);
			}else{
				myMap.put(text.charAt(i), 1);
			}
		}
		
		System.out.println(myMap);
		
		/*Stream<String> stream = Stream.of(text.toLowerCase().split("\\W+")).parallel();

		Map<String, Long> wordFreq = stream
	             .collect(Collectors.groupingBy(String::toString,Collectors.counting()));
		System.out.println(wordFreq);*/

	}
}
