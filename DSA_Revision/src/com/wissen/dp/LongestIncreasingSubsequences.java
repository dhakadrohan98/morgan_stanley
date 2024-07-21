package com.wissen.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequences {

	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n + 1][n + 1];
		// fill 2d dp with -1 values.
		for (int[] temp : dp) {
			Arrays.fill(temp, -1);
		}
		return rec(0, -1, nums, dp);
	}

	private int rec(int indx, int prev, int[] nums, int[][] dp) {
		// base case
		if (indx == nums.length) {
			return 0;
		}

		if (prev != -1 && dp[indx][prev] != -1) {
			return dp[indx][prev];
		}

		// include it in subsequence as strictly increasing subsequence.
		int left = 0;

		if (prev == -1 || nums[indx] > nums[prev]) {
			left = 1 + rec(indx + 1, indx, nums, dp);
		}

		// exclude from subsequence
		int right = 0 + rec(indx + 1, prev, nums, dp);
		int maxi = Math.max(left, right);
		if (prev != -1) {
			dp[indx][prev] = maxi;
		}
		return maxi;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
