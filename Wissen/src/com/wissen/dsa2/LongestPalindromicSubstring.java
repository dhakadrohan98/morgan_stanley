package com.wissen.dsa2;

import java.util.*;

//memoization is applied in recursive fashion.
public class LongestPalindromicSubstring {
	//TC: O(n^2)
	//SC: O(n)
	public static String longestPalindrome(String str) {
		Map<String, Boolean> hmap = new HashMap<>();
		int n = str.length();
		int longest = 0;
		String res = "";
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<=n; j++) {
				boolean isPalindrom = isPaindrome(str, i, j-1, hmap);
				if(isPalindrom == true) {
					if(j-i > longest) {
						longest = j-i;
						res = str.substring(i, j);
					}
				}
			}
		}
		return res;
	}
	
	private static boolean isPaindrome(String str, int i, int j, Map<String, Boolean> hmap) {
		String key = i+""+j;
		//memoization
		if(hmap.containsKey(key)) {
			return hmap.get(key);
		}
		//base case
		if(i >= j) {
			return true;
		}
		
		if(str.charAt(i) == str.charAt(j)) {
			boolean isPalindrom = isPaindrome(str, i+1, j-1, hmap);
			hmap.put(key, isPalindrom);
			return isPalindrom;
		}
		else {
			hmap.put(key, false);
			return false;
		}
	}

	public static void main(String[] args) {
		String str = "babad";
		System.out.println(longestPalindrome(str));
	}

}
