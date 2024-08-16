package com.wissen.variablesize.sliding.window;

import java.util.*;
public class MinWindowSubstring {
	 //TC: O(n+m)
    //SC: O(n+m)
	public static String minWindow(String s, String t) {
		String res = "";
		int m = t.length();
		//build required hashmap
		Map<Character, Integer> hmap = new HashMap<>();
		for(int i=0; i<m; i++) {
			char ch = t.charAt(i);
			hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
		}
		
		int n = s.length();
		int minWindowSize = Integer.MAX_VALUE;
		int count = hmap.size();
		int i=0, j=0;
		int startIndex = -1;
		int endIndex = -1;
		//variable size sliding window template
		while(j < n) {
			//do some calculations
			char currCh = s.charAt(j);
			if(hmap.containsKey(currCh)) {
				hmap.put(currCh, hmap.get(currCh)-1);
			} else {
				hmap.put(currCh, -1);
			}
			if(hmap.get(currCh) == 0) {
				count--;
			}
			
			if(count > 0) { //if condition is not met increment right pointer i.e. j
				j++;
			} 
			//condition is met, Now calculate ans till the condition is satisfying 
			//& remove elements from window (it means Shrink the window) from left side
			//until count becomes greater than 0.
			else if(count == 0){
				while(count == 0) {
					//caculate ans because condition is met till here
					//min window size is greater than the current window
					if(minWindowSize > j-i+1) {
						startIndex = i;
						endIndex = j;
						minWindowSize = j-i+1;
					}
					
					char ch = s.charAt(i);
					hmap.put(ch, hmap.get(ch) + 1);
					if(hmap.get(ch) > 0) {
						count++;
					}
					i++; //increment left pointer i
				}
				j++; ////increment right pointer j
			}
		}
		//t's all character with exact frequency is not present in s
		if(startIndex == -1 || minWindowSize == Integer.MAX_VALUE) {
			return "";
		}
		res = s.substring(startIndex, endIndex+1);
		return res;
	}

	public static void main(String[] args) {
		String s1 = "ADOBECODEBANC";
		String t1 = "ABC";
		
		String s2 = "a";
		String t2 =  "aa";
		
		String s3 = "ab";
		String t3 = "a";
		
		String res = minWindow(s1, t1);
		System.out.println(res + " its length is " + res.length());
	}

}
