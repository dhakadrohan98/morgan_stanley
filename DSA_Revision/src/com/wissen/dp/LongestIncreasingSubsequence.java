package com.wissen.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	//TC: O(2^n)
    //SC: O(n) stack space + O(n^2) memoization space
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] temp: dp) {
            Arrays.fill(temp, -1);
        }
        return solve(n-1, -1, nums, dp);
    }
    
    private int solve(int indx, int prev,int[] nums, int[][] dp) {
        //base case
        if(indx < 0) {
            return 0;
        }
        
        //memoization check
        if(prev != -1 && dp[indx][prev] != -1) {
            return dp[indx][prev];
        }
        
        //pick
        int pick = 0;
        if(prev == -1 || nums[indx] < nums[prev]) {
            pick = 1 + solve(indx-1, indx, nums, dp);
        }
        
        //not pick
        int notPick = 0 + solve(indx-1, prev, nums, dp);
        int maxi = Math.max(pick, notPick);
        if(prev != -1) {
            dp[indx][prev] = maxi;
        }
        return maxi;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
