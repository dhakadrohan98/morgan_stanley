package com.wissen.dp.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtraCharactersInAString {

	//TC: O(n^2)
	//SC: O(n + m) | n is length of string s | m is length of dictionary
	private int solve(int idx, String s, Set<String> set, int[] dp, int n) {
		// base case when idx is out of bound then return 0
		if (idx >= n) {
			return 0;
		}
		
		if(dp[idx] != -1) {
			return dp[idx];
		}

		int result = 1 + solve(idx + 1, s, set, dp, n);

		//TC: < O(n)
		for(int j = idx; j < n; j++) {
			String curr = s.substring(idx, j+1);
			if(set.contains(curr)) {
				//TC: O(n)
				//valid susbstring
				result = Math.min(result, solve(j + 1, s, set, dp, n));
			}
		}

		return dp[idx] = result;
	}

	public int minExtraChar(String s, String[] dict) {
		int n = s.length();
		int[] dp = new int[s.length() + 1];
		Arrays.fill(dp, -1);
		Set<String> set = new HashSet<>();
		for(int i = 0; i < dict.length; i++) {
			set.add(dict[i]);
		}
		return solve(0, s, set, dp, n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
