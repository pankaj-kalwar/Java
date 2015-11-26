package com.beyondalgo.java.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Question : How to find First Non-Repeated Character from String
	a.	for example in world "hello" , except 'l' all are non-repeated, but 'h' is the first non-repeated character. 
	Similarly in word "swiss" 'w' is the first non-repeated character.
 * 
 * */
public class FindFirstNonRepeatedCharacter {
	public static void main(String[] args) {
		
		String word = "hello";
		
		Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        System.out.println("Size : "+nonRepeating.size());
        System.out.println("Non Repeating character : "+nonRepeating.get(0));
	}
}
