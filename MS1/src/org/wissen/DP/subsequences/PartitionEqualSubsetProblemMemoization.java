package org.wissen.DP.subsequences;

import java.util.Arrays;

public class PartitionEqualSubsetProblemMemoization {
	
	//TC: O(2^n) + O(n)
	//SC: O(n) stack space + O(n^2) memoization
	public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i=0; i<n; i++) {
            total += nums[i];
        }
        
         if (total % 2 != 0) {
            return false; // Sum is odd, cannot partition equally
         }
        
         //total is od & length is also odd, then return false.
         if(total % 2 != 0 && n%2 != 0) {
            return false;
         }
        
        return isSubsetSum(n, nums, total/2);
    }
    
    public boolean isSubsetSum(int N, int arr[], int target){
	        int[][] dp = new int[N+1][target+1];
	        for(int[] temp : dp) {
	            Arrays.fill(temp, -1);
	        }
	        int res = dfs(arr, N-1, 0, target, dp);
	        if(res == 1) {
	        	return true;
	        } else {
	        	return false;
	        }
	    }
	    
	    public int dfs(int[] arr ,int indx, int sum, int target, int[][] dp) {
	        //base cases
	        if(sum == target) {
	            return 1;
	        }
	        if(sum > target || indx < 0) {
	            return 0;
	        }
	        if(dp[indx][sum] != -1) {
	            return dp[indx][sum];
	        }
	        
	        int left  = dfs(arr, indx-1, sum+arr[indx], target, dp);
	        int right = dfs(arr, indx-1, sum, target, dp);
	        if(left == 1 || right == 1) {
	        	dp[indx][sum] = 1;
	        } else {
	        	dp[indx][sum] = 0;
	        }
	        return dp[indx][sum];
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
