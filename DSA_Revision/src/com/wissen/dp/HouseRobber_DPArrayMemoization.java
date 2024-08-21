package com.wissen.dp;

import java.util.Arrays;

public class HouseRobber_DPArrayMemoization {
	// TC: O(n)
	// SC: O(n) stack space + O(n) memoization space
	public int rob(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n + 1];
		// fill dp with -1
		Arrays.fill(dp, -1);
		return solve(n - 1, nums, dp);
	}

	private int solve(int indx, int[] nums, int[] dp) {
		// base case
		if (indx < 0) {
			return 0;
		}

		// memoization check
		if (dp[indx] != -1) {
			return dp[indx];
		}

		int taken = nums[indx] + solve(indx - 2, nums, dp);
		int notTaken = 0 + solve(indx - 1, nums, dp);

		return dp[indx] = Math.max(taken, notTaken);
	}

	public static void main(String[] args) {

	}
}
