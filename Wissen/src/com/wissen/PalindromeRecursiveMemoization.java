package com.wissen;

import java.util.*;

public class PalindromeRecursiveMemoization {

	public static boolean isPalindrome(String str, int i, int j) {
		Map<String, Boolean> hmap = new HashMap<>();
		return helper(str, hmap, i, j);
	}

	public static boolean helper(String str, Map<String, Boolean> hmap, int i, int j) {
		String key = i + "" + j;
		// base case
		if (i >= j) {
			return true;
		}

		if (hmap.containsKey(key)) {
			return hmap.get(key);
		}

		if (str.charAt(i) == str.charAt(j)) {
			boolean ans = helper(str, hmap, i + 1, j - 1);
			hmap.put(key, ans);
			return ans;
		} else {
			hmap.put(key, false);
			return false;
		}
	}

	public static void main(String[] args) {
		String input = "racecar";
		int n = input.length();
		boolean isPal = isPalindrome(input, 0, n - 1);

		if (isPal) {
			System.out.println("The string is a palindrome.");
		} else {
			System.out.println("The string is not a palindrome.");
		}
	}
}
