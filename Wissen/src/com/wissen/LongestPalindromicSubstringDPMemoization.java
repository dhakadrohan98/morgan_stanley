package com.wissen;

import java.util.*;

public class LongestPalindromicSubstringDPMemoization {
	//TC: O(n^2)
	//SC: O(n) stack space
	public String longestPalindrome(String str) {
		int max = 1;
		int sp = 0;

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (isPalindrome(str, i, j) == true) {
					if (j - i + 1 > max) {
						max = j - i + 1;
						sp = i;
					}
				}
			}
		}
		return str.substring(sp, sp + max);
	}

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
		// TODO Auto-generated method stub

	}

}
