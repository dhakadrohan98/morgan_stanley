package com.wissen.string;

import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfConsistentStrings {

	// TC: O(m + (n*k))
	// m -> length of allowed string
	// n -> length of String arrays
	// where k is longest length of string in words array
	// SC: O(26)
	public int countConsistentStrings(String allowed, String[] words) {
		int counter = 0;
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < allowed.length(); i++) {
			set.add(allowed.charAt(i));
		}

		for (String str : words) {
			boolean flag = true;
			for (int i = 0; i < str.length(); i++) {
				if (!set.contains(str.charAt(i))) {
					flag = false;
				}
			}
			if (flag)
				counter++;
		}
		return counter;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
