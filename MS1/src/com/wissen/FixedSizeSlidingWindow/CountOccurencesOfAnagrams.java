package com.wissen.FixedSizeSlidingWindow;

import java.util.*;

//clean code diagram
public class CountOccurencesOfAnagrams {

		public static int search(String pat, String txt) {
	
			Map<Character, Integer> hmap = new HashMap<>();
			for (int i = 0; i < pat.length(); i++) {
				char ch = pat.charAt(i);
				if (hmap.containsKey(ch)) {
					hmap.put(ch, hmap.get(ch) + 1);
				} else {
					hmap.put(ch, 1);
				}
			}
	
			int i = 0, j = 0;
			int distinctCharacterCount = hmap.size();
			int k = pat.length();
			int ans = 0;
	
			while (j < txt.length()) {
				// calculation
				char ch = txt.charAt(j);
				if (hmap.containsKey(ch)) {
					hmap.put(ch, hmap.get(ch) - 1);
				}
	
				if (hmap.containsKey(ch) && hmap.get(ch) == 0) {
					distinctCharacterCount--;
				}
	
				if (j - i + 1 < k) { //// window size is less than k
					j++;
				} else if (j - i + 1 == k) { // window size is equal to k.
					// calculating answer
					if (distinctCharacterCount == 0) {
						ans++;
					}
					// sliding the window
					// calculation for ith index before moving it ahead by one step.
					char ichar = txt.charAt(i);
					if (hmap.containsKey(ichar)) {
						hmap.put(ichar, hmap.get(ichar) + 1);
						if (hmap.get(ichar) == 1) {
							distinctCharacterCount++;
						}
					}
					i++;
					j++;
				}
			}
			return ans;
		}
}

