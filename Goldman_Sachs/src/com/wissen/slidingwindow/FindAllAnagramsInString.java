package com.wissen.slidingwindow;

import java.util.*;

public class FindAllAnagramsInString {
	 //TC: O(n+m)
    //SC: O(m)
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<Integer>();
		int k = p.length();
		int n = s.length();
		if(n == 0) {
			return res;
		}
		
		Map<Character, Integer> hmap = new HashMap<>();
		for(int i=0; i<k; i++) {
			char ch = p.charAt(i);
			hmap.put(ch, hmap.getOrDefault(ch, 0)+1);
		}
		int i=0, j=0;
		int count = hmap.size();
		
		while(j < n) {
			//Do some calculations
			char ch = s.charAt(j);
			if(p.contains(ch+"")) {
				hmap.put(ch, hmap.get(ch)-1);
				if(hmap.get(ch) == 0) {
					count--;
				}
			}
			
			if(j-i+1 < k) {
				j++;
			} else if(j-i+1 == k) {
				//calculate ans
				if(count == 0) {
					res.add(i);
				}
				char ch1 = s.charAt(i);
				//remove calculations for ans
				if(hmap.containsKey(ch1)) {
					hmap.put(ch1, hmap.getOrDefault(ch1, 0)+1);
					//curr ith character value becomes 1 in hmap
					if(hmap.get(ch1) == 1) {
						count++;
					}
				}
				//slide the window.
				i++;
				j++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		
		String s1 = "abab";
		String p1 = "ab";
		System.out.println(findAnagrams(s1, p1));

	}

}
