package com.wissen.dp;

public class PartitionEqualSubsetSumMemoizationWay {
	
	public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }

        if (total % 2 != 0) {
            return false; // Sum is odd, cannot partition equally
        }

        int target = total / 2;
        Boolean[][] memo = new Boolean[n][target + 1];
        return isSubsetSum(nums, n - 1, target, memo);
    }

    private boolean isSubsetSum(int[] arr, int index, int target, Boolean[][] memo) {
        // Base cases
        if (target == 0) return true;
        if (index < 0 || target < 0) return false;

        // Check if the result is already computed
        if (memo[index][target] != null) {
            return memo[index][target];
        }

        // Recursively check if the subset sum can be achieved by including or excluding the current element
        boolean notTaken = isSubsetSum(arr, index - 1, target, memo);

        boolean taken = false;
        if (arr[index] <= target) {
            taken = isSubsetSum(arr, index - 1, target - arr[index], memo);
        }

        // Store the result in the memoization table
        memo[index][target] = notTaken || taken;
        return memo[index][target];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
