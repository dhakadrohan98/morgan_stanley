package com.wissen.dp;

public class PartitionSetInto2SubsetsWithMinAbsoluteSumDiff {

	//TC: O(N*K)
	//SC: O(N*K)
	public static int partitionIntoSubsetMinimal(int n, int[] arr) {
		int totalSum = 0;
		int ans = -1;
		for (int i = 0; i < n; i++) {
			totalSum += arr[i];
		}

		ans = isSubsetSum(n, arr, Math.abs(totalSum));
		return ans;
	}

	private static int isSubsetSum(int n, int[] arr, int k) {
		// Create a boolean DP table with dimensions [n+1][k+1]
		boolean dp[][] = new boolean[n + 1][k + 1];
		int minimalDiff = Integer.MAX_VALUE;

		// Initialize the first row of the DP table if target can be 0
		// till any index like n-1,n-2,n-3,......,0 indexs
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		// Fill in the DP table using bottom-up approach
		for (int ind = 1; ind <= n; ind++) {
			for (int target = 1; target <= k; target++) {
				// Calculate if the current target can be achieved without taking the current
				// element
				boolean notTaken = dp[ind - 1][target];

				// Calculate if the current target can be achieved by taking the current element
				boolean taken = false;
				if (arr[ind - 1] <= target) {
					taken = dp[ind - 1][target - arr[ind - 1]];
				}

				// Store the result in the DP table
				dp[ind][target] = notTaken || taken;
			}
		}

		// logic for partition into two subset with minimal difference
		for (int i = 0; i < k/2; i++) {
			// if partition is possible for target i in last row
			if (dp[n-1][i] == true) {
				int sum1 = i;
				int sum2 = k - sum1;
				minimalDiff = Math.min(minimalDiff, Math.abs(sum1 - sum2));
			}
		}

		// The final result is stored in the bottom-right cell of the DP table
		return minimalDiff;
	}

	public static void main(String[] args) {
		int[] arr = {3,2,7};
		int n = arr.length;
		System.out.println(partitionIntoSubsetMinimal(n, arr));

	}

}
