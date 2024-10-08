package com.wissen.DSAproblems;

import java.util.*;

//Generate all subsequence using memoization (hmap)
public class GenearateAllSubsequences {

	public static void generate(String str) {
		int n = str.length();
		String res = "";
		List<String> list = new ArrayList<>();
		Map<String, String> hmap = new HashMap<>();
		helper(str, n-1, res, list, hmap);
		int count = 0;
		
		for(String temp: list) {
			System.out.print(temp+" ");
		}
	}
	
	
	private static void helper(String str, int indx, String res, List<String> list, Map<String, String> hmap) {
		String key = res + indx;
		//base case
		if(indx < 0) {
			if(!hmap.containsKey(key)) {
				hmap.put(key, res);
			}
			list.add(res);
			return ;
		}
		
		if(hmap.containsKey(key)) {
			list.add(hmap.get(key));
			return;
		}
		
		//include current character & move back by one step
		helper(str, indx-1, res+str.charAt(indx), list, hmap);
		//exclude current character & move back by one step
		helper(str, indx-1, res, list, hmap);
		
	}


	public static void main(String[] args) {
		String str = "abc";
		String str1 = "bbbab";
		String str2 = "abcde";
		//in str1 characters are repeated here
		generate(str1);
	}

}
