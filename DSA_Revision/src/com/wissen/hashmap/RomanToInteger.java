package com.wissen.hashmap;

import java.util.*;

public class RomanToInteger {

	//TC: O(n)
	//SC: O(1)
	public static int romanToInt(String s) {
		int n = s.length();
		Map<String, Integer> hmap = new HashMap<>();

		hmap.put("I", 1);
		hmap.put("IV", 4);
		hmap.put("V", 5);
		hmap.put("IX", 9);
		hmap.put("X", 10);
		hmap.put("XL", 40);
		hmap.put("L", 50);
		hmap.put("XC", 90);
		hmap.put("C", 100);
		hmap.put("CD", 400);
		hmap.put("D", 500);
		hmap.put("CM", 900);
		hmap.put("M", 1000);
		
		if(n == 1) {
			return hmap.get(s.charAt(0)+"");
		}
		int i=1;
		int ans = 0;
		while(i < n) {
			String temp = s.charAt(i-1) +""+ s.charAt(i);
			if(hmap.containsKey(temp)) {
				ans += hmap.get(temp);
				i += 2;
				
			} else {
//				System.out.println(s.charAt(i-1) +" index " + i);
				int prev = hmap.get(s.charAt(i-1)+"");
				ans += prev;
				i += 1;
			}
		}
		//check if no subtracting Roman characters are not encountered & calculation for last character is remained
		if(i == n) {
			ans += hmap.get(s.charAt(i-1)+"");
		}
		return ans;

	}

	public static void main(String[] args) {
		String str = "III";
		String str1 = "MCMXCIV";
		String str2 = "LVIII";
		
		System.out.println(romanToInt(str2));

	}

}
