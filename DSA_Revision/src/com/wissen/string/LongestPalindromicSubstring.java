package com.wissen.string;

public class LongestPalindromicSubstring {

	// TC: O(n^2)
	// SC: O(1)
	public String longestPalindrome(String s) {
		int len = s.length();
		int start = 0, end = 0;
		for (int i = 0; i < len - 1; i++) {
			int left = expandFromCenter(i, i, s);
			int right = expandFromCenter(i, i + 1, s);
			int maxLen = Math.max(left, right);
			if (end - start < maxLen) {
				start = i - (maxLen - 1) / 2;
				end = i + maxLen / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandFromCenter(int i, int j, String s) {
		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				i--;
				j++;
			} else {
				break;
			}
		}
		return j - i - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
