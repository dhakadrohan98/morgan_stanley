package org.wissen.DP.subsequences;

public class PartitionEqualSubsetProblemTabulation {
//	Time Complexity: O(N*K)
//	Reason: There are two nested loops
//	Space Complexity: O(N*K)
//	Reason: We are using an external array of size ‘N*K’. Stack Space is eliminated.
	public boolean canPartition(int[] nums) {
	    int n = nums.length;
	    int total = 0;
	    for (int i = 0; i < n; i++) {
	        total += nums[i];
	    }

	    if (total % 2 != 0) {
	        return false; // Sum is odd, cannot partition equally
	    }

	    return isSubsetSum(n, nums, total / 2);
	}

	static boolean isSubsetSum(int n, int[] arr, int k) {
	    // Create a boolean DP table with dimensions [n+1][k+1]
	    boolean dp[][] = new boolean[n + 1][k + 1];

	    // Initialize the first row of the DP table
	    for (int i = 0; i <= n; i++) {
	        dp[i][0] = true;
	    }

	    // Fill in the DP table using bottom-up approach
	    for (int ind = 1; ind <= n; ind++) {
	        for (int target = 1; target <= k; target++) {
	            // Calculate if the current target can be achieved without taking the current element
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

	    // The final result is stored in the bottom-right cell of the DP table
	    return dp[n][k];
	}
}
