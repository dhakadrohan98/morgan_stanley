package com.wissen.dp;

import java.util.*;

public class MinimumPathSumInTraingularGrid {
	// TC: O(m*n)
	// SC: O(m*n) stack space + O(m*n) memoization space
	public int minimumTotal(List<List<Integer>> triangle) {
		int m = triangle.size();
		int n = triangle.get(m - 1).size();

		int[][] dp = new int[m + 1][n + 1];
		for (int[] arr : dp) {
			Arrays.fill(arr, (int) Math.pow(10, 9));
		}

		return rec(0, 0, triangle, dp);
	}

	private int rec(int i, int j, List<List<Integer>> triangle, int[][] dp) {
		// base case
		// if we have reached till last row
		if (i == triangle.size() - 1) {
			return triangle.get(i).get(j);
		}

		// memoization check
		if (dp[i][j] != (int) Math.pow(10, 9)) {
			return dp[i][j];
		}

		int sameIdxNextRow = triangle.get(i).get(j) + rec(i + 1, j, triangle, dp);
		int nextIdxNextRow = triangle.get(i).get(j) + rec(i + 1, j + 1, triangle, dp);

		return dp[i][j] = Math.min(sameIdxNextRow, nextIdxNextRow);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
