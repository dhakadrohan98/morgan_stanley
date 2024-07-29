package com.wissen.dp.strings;

import java.util.Arrays;

public class EditDistance {

	// TC: < O(3^(m*n))
	// SC: O(m+n) + O(m*n)
	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int[] temp : dp) {
			Arrays.fill(temp, -1);
		}
		return solve(n - 1, m - 1, word1, word2, dp);
	}

	private int solve(int i, int j, String str1, String str2, int[][] dp) {
		// base cases when i or j ran out of index
		if (i < 0) { // insert str[0,1,....,j+1] characters
			return j + 1;
		}
		if (j < 0) { // delete str[0,1,....,i+1] characters
			return i + 1;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (str1.charAt(i) == str2.charAt(j)) {
			return dp[i][j] = solve(i - 1, j - 1, str1, str2, dp);
		}

		int replace = solve(i - 1, j - 1, str1, str2, dp);
		int insert = solve(i, j - 1, str1, str2, dp);
		int delete = solve(i - 1, j, str1, str2, dp);
		int minOps = 1 + Math.min(replace, Math.min(insert, delete));
		return dp[i][j] = minOps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
