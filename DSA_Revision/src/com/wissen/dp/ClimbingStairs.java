package com.wissen.dp;

import java.util.Arrays;

public class ClimbingStairs {
	
	//TC: O(2^n)
	//SC: O(n) stack space + O(n) dp array
	public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return rec(n, dp);
    }
    
    private int rec(int indx, int[] dp){
        //base case
        if(indx == 1 || indx == 0) {
            return 1;
        }
        if(indx < 0) {
            return 0;
        }
        
        //if dp has stored total value for indx, then return it
        if(dp[indx] != -1) {
            return dp[indx];
        }
        //one step
        int left = rec(indx-1, dp);
        //two step
        int right = rec(indx-2, dp);
        dp[indx] = left + right;
        return left + right;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
