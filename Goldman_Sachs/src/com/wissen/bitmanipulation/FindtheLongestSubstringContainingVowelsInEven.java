package com.wissen.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class FindtheLongestSubstringContainingVowelsInEven {
	
	//TC: O(n) + O(5)
	//SC: O(32) unique combinations to store state in map + O(5) to make a currState
	public static int findTheLongestSubstring(String s) {
		// s = "elee";
		Map<String, Integer> map = new HashMap<>();
		int[] vowelCount = new int[5];
		int n = s.length();
		
		String currState = "00000";
		map.put(currState, -1);
		
		int maxLength = 0;
		
		for(int i=0; i<n; i++) {
			//update count for the vowel encountered
			if(s.charAt(i) == 'a') {
				vowelCount[0] = (vowelCount[0] + 1) % 2;
			} else if(s.charAt(i) == 'e') {
				vowelCount[1] = (vowelCount[1] + 1) % 2;
			} else if(s.charAt(i) == 'i') {
				vowelCount[2] = (vowelCount[2] + 1) % 2;
			} else if(s.charAt(i) == 'o') {
				vowelCount[3] = (vowelCount[3] + 1) % 2;
			} else if(s.charAt(i) == 'u') {
				vowelCount[4] = (vowelCount[4] + 1) % 2;
			}
			
			// Create a string representing the current parity state of vowels
			//A parity bit is a single bit of data appended to a binary string
			
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<5; j++) {
				sb.append(vowelCount[j]);
			}
			currState = sb.toString();
			
			//check if we've seen this state before
			if(map.containsKey(currState)) {
				maxLength = Math.max(maxLength, i - map.get(currState));
			} else {
				map.put(currState, i);
			}
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		String str = "eleetminicoworoep";
		String str2 = "leetcodeisgreat";
		String str3 = "bcbcbc";
		int res = findTheLongestSubstring(str3);
		System.out.println(res);

	}

}
