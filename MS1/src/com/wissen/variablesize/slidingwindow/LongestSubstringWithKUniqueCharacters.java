package com.wissen.variablesize.slidingwindow;

import java.util.*;

public class LongestSubstringWithKUniqueCharacters {
	//TC: O(n)
	//SC: O(n)
	public static int longestkSubstr(String s, int k) {
		int n = s.length();
		int i=0, j=0;
		int longest = -1;
		Map<Character, Integer> hmap = new HashMap<>();
		
		while(j < n) {
			char ch = s.charAt(j);
			hmap.put(ch, hmap.getOrDefault(ch, 0)+1);
			
			if(hmap.size() < k) {
				j++;
			} else if(hmap.size() == k) {
				int currLen = j-i+1;
				longest = Math.max(longest, currLen);
				j++;
			} else {
				while(hmap.size() > k) {
					char tempCh = s.charAt(i);
					hmap.put(tempCh, hmap.get(tempCh)-1);
					if(hmap.get(tempCh) == 0) {
						hmap.remove(tempCh);
					}
					i++;
				}
				if(hmap.size() == k) {
					longest = Math.max(longest, j-i+1);
				}
				j++;
			}
		}
		return longest;
	}
	
	
	public static void main(String[] args) {
		String s = "aabacbebebe";
		int k = 3;
		System.out.println(longestkSubstr(s, k));

	}

}
