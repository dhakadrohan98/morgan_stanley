package com.wissen.DP;

import java.util.Arrays;

public class LongestIncreasingSubseqV_2 {
	
	//TC: O(2^n)
    //SC: O(n) stack space + O(n) memoization
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int curr = n-1;
        int prev = -1;
        //memoization
        int[][] dp = new int[n+1][n+1];
        //fill dp grids with -1 values intially
        for(int[] temp:dp) {
            Arrays.fill(temp , -1);
        }
        return rec(curr, prev, nums, dp);
    }
    
    private int rec(int curr, int prev, int[] nums, int[][] dp) {
        //base case
        if(curr < 0) {
            return 0;
        }
        
        if(prev != -1 && dp[curr][prev] != -1) {
            return dp[curr][prev];
        }
        
        int left = 0;
        //Add 1 if it is last indx element or if element at current indx < previous indx's element
        if(prev == -1 || nums[curr] < nums[prev]) {
            left = 1 + rec(curr-1, curr, nums, dp);
        }
           
        //exclude
        int right = rec(curr-1, prev, nums, dp);
        if(prev != -1) {
            dp[curr][prev] = Math.max(left, right);    
        }
        return Math.max(left, right);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
