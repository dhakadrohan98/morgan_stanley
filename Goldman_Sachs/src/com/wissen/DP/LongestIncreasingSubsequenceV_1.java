package com.wissen.DP;

import java.util.Arrays;

public class LongestIncreasingSubsequenceV_1 {
	
	//TC: O(2^n)
    //SC: O(n) memoization array space + O(n) stack space
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        
        for(int[] temp: dp) {
           Arrays.fill(temp, -1); 
        }
        return helper(0, -1, nums, dp);
    }
    
    private int helper(int indx,int prevIndx, int[] nums,int[][] dp) {
        //base case
        //ran out of index
        if(indx == nums.length) {
            return 0;
        }
        //if map contains calculations for indx & prevIndx pair already, then return from value of that key from map.
        if(prevIndx != -1 && dp[indx][prevIndx] != -1) {
            return dp[indx][prevIndx];
        }
        
        int take = 0;
        if(prevIndx == -1 || nums[indx] > nums[prevIndx]) {
            take = 1 + helper(indx+1, indx, nums, dp);
        }
        int notTake = 0 + helper(indx+1, prevIndx, nums, dp);
        
        int longest = Math.max(take, notTake);
        if(prevIndx != -1) {
            dp[indx][prevIndx] = longest;    
        }
        return longest;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
