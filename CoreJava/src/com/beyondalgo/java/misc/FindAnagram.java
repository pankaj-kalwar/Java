package com.beyondalgo.java.misc;

import java.util.Arrays;

public class FindAnagram {
	/*
	 * Process 1 :
	 * 
	 * One way to find if two Strings are anagram in Java. This method assumes
	 * both arguments are not null and in lowercase.
	 * 
	 * @return true, if both String are anagram
	 */
	public static boolean isAnagram(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}

		char[] chars = word.toCharArray();

		for (char c : chars) {
			int index = anagram.indexOf(c);
			if (index != -1) {
				anagram = anagram.substring(0, index)
						+ anagram.substring(index + 1, anagram.length());
			} else {
				return false;
			}
		}

		return anagram.isEmpty();
	}

	/*
	 * Process 2:
	 * 
	 * Another way to check if two Strings are anagram or not in Java This
	 * method assumes that both word and anagram are not null and lowercase
	 * 
	 * @return true, if both Strings are anagram.
	 */
	public static boolean iAnagram(String word, String anagram) {
		char[] charFromWord = word.toCharArray();
		char[] charFromAnagram = anagram.toCharArray();
		Arrays.sort(charFromWord);
		Arrays.sort(charFromAnagram);

		return Arrays.equals(charFromWord, charFromAnagram);
	}

	/*
	 * Process 3 :
	 */
	public static boolean checkAnagram(String first, String second) {
		char[] characters = first.toCharArray();
		StringBuilder sbSecond = new StringBuilder(second);

		for (char ch : characters) {
			int index = sbSecond.indexOf("" + ch);
			if (index != -1) {
				sbSecond.deleteCharAt(index);
			} else {
				return false;
			}
		}
		return sbSecond.length() == 0 ? true : false;
	}

	/*
	 * Process 4 :
	 */
	public static boolean anagramUsingAscii(String a, String b) {
		if (a == b) {
			return true;
		}
		if (a == null || b == null)
			return false;

		if (a.length() != b.length())
			return false;

		char[] aArr = a.toLowerCase().toCharArray();
		char[] bArr = b.toLowerCase().toCharArray();

		int[] counts = new int[26];

		for (int i = 0; i < aArr.length; i++) {
			counts[aArr[i] - 97]++; 
			counts[bArr[i] - 97]--;
		}
		for (int i = 0; i < 26; i++) {
			if (counts[i] != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkAnagram("hello", "ollhe"));
		System.out.println(iAnagram("hello", "helol"));
		System.out.println(isAnagram("b", "bbb"));
		
		System.out.println(anagramUsingAscii("abc", "bca"));
	}
}
