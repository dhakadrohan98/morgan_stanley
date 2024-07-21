package com.wissen.dp;

import java.util.Arrays;

public class CoinChangeInfiniteSupplyWithTargetSum {
	
	//TC: O(2^n)
	//SC: O(n*m) stack space + O(n*sum) dp memoization
	public long count(int nums[], int n, int sum) {
        long[][] dp = new long[n+1][sum+1];
        for(long[] temp : dp) {
            Arrays.fill(temp, -1l);
        }
        return solve(nums, n-1, sum, dp);
    }
    
    private long solve(int[] nums, int indx, int sum, long[][] dp) {
        //base case
        if(sum == 0) {
            return 1;
        }
        
        if(indx < 0) {
            return 0;
        }
        
        if(dp[indx][sum] != -1) {
            return dp[indx][sum];
        }
        
        long left = 0l;
        //include many no. of times
        if(sum >= nums[indx]) {
            left = solve(nums, indx, sum-nums[indx], dp);
        }
        long right = solve(nums, indx-1, sum, dp);
        dp[indx][sum] = left + right;
        return left + right;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
