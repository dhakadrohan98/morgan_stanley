package com.wissen.two.pointers;

import java.util.*;
public class LongestWordInDictionary {

	// Two pointer approach
	// TC: O(n*dict.length)
	// SC: O(1)
	public String findLongestWord(String s, List<String> dictionary) {
		int n = s.length();
		int m = dictionary.size();
		int i = 0;
		int maxLen = 0;
		String maxWord = "";

		for (int k = 0; k < m; k++) {
			String word = dictionary.get(k);
			int j = 0;
			while (i < n && j < word.length()) {
				if (s.charAt(i) == word.charAt(j)) {
					i++;
					j++;
				} else {
					i++;
				}
			}
			if (j == word.length()) {
				if (j > maxLen) {
					maxLen = j;
					maxWord = word;
				} else if (j == maxLen) {
					if (word.compareTo(maxWord) < 0) {
						// curr word is greater than maxWord
						maxWord = word;
					}
				}
			}
			// resetting i pointer to 0 for s string.
			i = 0;
		}
		return maxWord;
	}

	public static void main(String[] args) {
		String s1 = "npple";
		String s2 = "monke";

		System.out.println(s1.compareToIgnoreCase(s2));

	}

}
