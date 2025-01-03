package com.wissen;

public class FirstPalindromicStringintheArray {

	public static String firstPalindrome(String[] words) {
		//TC: < O(n^2)
		//SC: O(|words.length|)
		String rev = "";
		boolean isWordPalindrome = true;
		for (int i = 0; i < words.length; i++) {
			String str = words[i];
			int n = str.length();

			for (int j = 0, k = n - 1; j <= n / 2; j++, k--) {
				if (str.charAt(j) != str.charAt(k)) {
					isWordPalindrome = false;
					break;
				}
			}

			if (isWordPalindrome == true) {
				return str;
			}
			// reset isWordPalindrome to true
			isWordPalindrome = true;
		}
		return rev;
	}

	public static void main(String[] args) {
		String[] words = { "abc", "car", "ada", "racecar", "cool" };
		System.out.println(firstPalindrome(words));

	}

}
