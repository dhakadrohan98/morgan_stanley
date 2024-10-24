package com.wissen.blind75;

public class KadaneAlgorithmMaximumSubarraySum {

	// TC: O(n)
	// SC: O(1)
	public int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int n = nums.length;
		int currSum = 0;

		for (int i = 0; i < n; i++) {
			currSum += nums[i];
			maxSum = Math.max(maxSum, currSum);
			if (currSum < 0) {
				currSum = 0;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
