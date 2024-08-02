package com.wissen.slidingwindow;

import java.util.*;

public class FindAllAnagramsInaString65_65 {
	//TC: O(m+n)
    //SC: O(n)
	public static List<Integer> findAnagrams(String s, String p) {
		Map<Character, Integer> hmap = new HashMap<>();
		int n = s.length();
		int k = p.length();
		for(int i=0; i<k; i++) {
			char ch = p.charAt(i);
			hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
		}
		int i=0, j=0;
		int uniqueCharCount = hmap.size();
		List<Integer> ans = new ArrayList<>();
		
		while(j < n) {
			//do some calculations for jth index
			char ch = s.charAt(j);
			if(p.contains(ch+"")) {
				hmap.put(ch, hmap.get(ch) - 1);
				if(hmap.get(ch) == 0) {
					uniqueCharCount--;
				}
			}
			//check the window size whether it is equal to k or less than k
			if(j-i+1 < k) {
				j++;
			} else if(j-i+1 == k) {
				//calculate ans
				if(uniqueCharCount == 0) {
					ans.add(i);
				}
				//remove calculations for i
				char ch1 = s.charAt(i);
				if(hmap.containsKey(ch1)) {
					hmap.put(ch1, hmap.getOrDefault(ch1, 0) + 1);
					if(hmap.get(ch1) == 1) {
						uniqueCharCount++;
					}
				}
				//slide the window
				i++;
				j++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println(findAnagrams(s, p));

		String s1 = "baa";
		String p1 = "aa";
		System.out.println(findAnagrams(s1, p1));

		String s2 = "ababababab";
		String p2 = "aab";
		System.out.println(findAnagrams(s2, p2));
	}
}
