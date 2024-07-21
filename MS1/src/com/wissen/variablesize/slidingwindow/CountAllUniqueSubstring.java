package com.wissen.variablesize.slidingwindow;

import java.util.*;

public class CountAllUniqueSubstring {

	//TC: O(n^3)
	//SC: O(n) hashset
	public static int findSubstrings(String s) {
		int n = s.length(); // Length of the input string
		int start = 0, end = 0; // Pointers to maintain the sliding window
		int count = 0; // Variable to keep track of the number of valid substrings
		Set<Character> charSet = new HashSet<>(); // Set to store unique characters in the current window

		// Traverse through the string using the end pointer
		while (end < n) {
			char endChar = s.charAt(end); // Get the current character at the end pointer
			// If the current character is already in the set, move the start pointer to the
			// right
			while (charSet.contains(endChar)) {
				charSet.remove(s.charAt(start)); // Remove the character at the start pointer from the set
				start++; // Increment the start pointer
			}
			charSet.add(endChar); // Add the current character to the set
			count += end - start + 1; // Calculate the number of valid substrings ending at the current end position
			end++; // Increment the end pointer
		}

		return count; // Return the total count of valid substrings
	}

	public static void main(String[] args) {
		String str ="abac";
		System.out.println(findSubstrings(str));

	}

}
