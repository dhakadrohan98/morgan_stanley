package com.wissen.dp;

import java.util.Arrays;

public class MinimumPathSum {
	// TC: < O(2^(m*n))
	// SC: O(n+m) stack space + O(m*n) memoization space
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m + 1][n + 1];
		for (int[] temp : dp) {
			Arrays.fill(temp, (int) Math.pow(10, 9));
		}

		return rec(m - 1, n - 1, grid, dp);
	}

	private int rec(int i, int j, int[][] grid, int[][] dp) {
		// base cases

		if (i == 0 && j == 0) {
			return grid[0][j];
		}

		if (i < 0 || j < 0) {
			return (int) Math.pow(10, 9);
		}

		// memoization check
		if (dp[i][j] != (int) Math.pow(10, 9)) {
			return dp[i][j];
		}

		// upward step
		int up = grid[i][j] + rec(i - 1, j, grid, dp);
		// leftside step
		int left = grid[i][j] + rec(i, j - 1, grid, dp);
		return dp[i][j] = Math.min(up, left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
