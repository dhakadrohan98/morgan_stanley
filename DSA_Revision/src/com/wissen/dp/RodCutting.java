package com.wissen.dp;

import java.util.Arrays;

public class RodCutting {
	// TC: O(2^(n^2))
	// SC: O(n+n) stack space + O(n*n) memoizatoin space
	public int cutRod(int price[], int n) {
		int[][] dp = new int[n + 1][n + 1];
		for (int[] temp : dp) {
			Arrays.fill(temp, -1);
		}
		return solve(n - 1, n, price, dp);
	}

	private int solve(int indx, int N, int[] price, int[][] dp) {
		// base case
		if (indx < 0) {
			return 0;
		}

		// memoization check
		if (dp[indx][N] != -1) {
			return dp[indx][N];
		}

		int take = Integer.MIN_VALUE;
		// current rod length after cutting
		int rodLength = indx + 1;
		if (rodLength <= N) {
			take = price[indx] + solve(indx, N - rodLength, price, dp);
		}

		int notTake = 0 + solve(indx - 1, N, price, dp);
		return dp[indx][N] = Math.max(take, notTake);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
