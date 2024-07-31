package com.wissen.variablesize.sliding.window;

import java.util.*;

public class LongestSubstringRepeatingCharacter {
	
	//TC: O(n)
	//SC: O(n)
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		int i = 0, j = 0;
		int n = s.length();
		
		Set<Character> set = new HashSet<>();

		while (j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				max = Math.max(max, j - i + 1);
				j++;
			} else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		String s1 = "dvdf";
		System.out.println(lengthOfLongestSubstring(s1));

	}

}
