package com.wissen.backtrack;

import java.util.*;

public class PrintallLCSsequences2 {

	public List<String> all_longest_common_subsequences(String s, String t) {
		int m = s.length();
		int n = t.length();
		int[][] dp = new int[m + 1][n + 1];

		// Fill dp array
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		System.out.println("DP table");
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		// Backtrack to find all LCS
		Set<String> lcsSet = new HashSet<>();
		backtrack(dp, s, t, m, n, "", lcsSet);

		// Convert set to list and sort lexicographically
		List<String> result = new ArrayList<>(lcsSet);
		Collections.sort(result);
		return result;
	}

	private void backtrack(int[][] dp, String s, String t, int i, int j, String lcs, Set<String> lcsSet) {
		if (i == 0 || j == 0) {
			//we have reached the end of one of the strings
			lcsSet.add(new StringBuilder(lcs).reverse().toString());
			return;
		}
		//If the characters s.charAt(i - 1) and t.charAt(j - 1) match, it means this 
		//character is part of the LCS. We move diagonally up-left in the dp array and 
		//add this character to the current LCS.
		if (s.charAt(i - 1) == t.charAt(j - 1)) {
			backtrack(dp, s, t, i - 1, j - 1, lcs + s.charAt(i - 1), lcsSet);
		} else {
			if (dp[i - 1][j] >= dp[i][j - 1]) {
				backtrack(dp, s, t, i - 1, j, lcs, lcsSet);
			}
			if (dp[i][j - 1] >= dp[i - 1][j]) {
				backtrack(dp, s, t, i, j - 1, lcs, lcsSet);
			}
		}
	}

	public static void main(String[] args) {
		PrintallLCSsequences2 lcs = new PrintallLCSsequences2();
		String s = "AGTGATG";
		String t = "GTTAG";
		List<String> result = lcs.all_longest_common_subsequences(s, t);
		System.out.println(result);
	}
}
