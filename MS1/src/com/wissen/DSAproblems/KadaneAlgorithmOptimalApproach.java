package com.wissen.DSAproblems;

public class KadaneAlgorithmOptimalApproach {

	// TC: O(n)
	// SC: O(1)
	private long maxSubarraySum(int arr[], int n) {
		long maxSum = Long.MIN_VALUE;
		long currSum = 0;

		for (int i = 0; i < n; i++) {
			currSum += arr[i];
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
