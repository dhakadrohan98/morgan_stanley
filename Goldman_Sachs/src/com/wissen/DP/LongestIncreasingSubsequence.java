package com.wissen.DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	// TC: < O(2^n)
	// SC: O(n) stack space + 2D array for memoization
	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int prev_indx = -1;
		int[][] dp = new int[n + 1][n + 1];
		for (int[] temp : dp) {
			Arrays.fill(temp, -1);
		}
		return helper(0, prev_indx, nums, dp);
	}

	public int helper(int indx, int prev_indx, int[] nums, int[][] dp) {
		String key = indx + "_" + prev_indx;
		// base case
		if (indx == nums.length) {
			return 0;
		}

		if (dp[indx][prev_indx + 1] != -1) {
			return dp[indx][prev_indx + 1];
		}
		int notPick = 0 + helper(indx + 1, prev_indx, nums, dp);
		int pick = 0;
		if (prev_indx == -1 || nums[indx] > nums[prev_indx]) {
			pick = 1 + helper(indx + 1, indx, nums, dp);
		}
		dp[indx][prev_indx + 1] = Math.max(notPick, pick);
		return Math.max(pick, notPick);
	}

	public static void main(String[] args) {
	}

}
