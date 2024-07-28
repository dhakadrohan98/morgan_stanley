package com.wissen.dp.knapsack;

import java.util.Arrays;

public class _01Kanpsack {
	
	//TC: O(2^(m*n))
	//SC: O(n+m) stack space + O(m*n) memoizatoin two dp
	public static int knapSack(int W, int wt[], int val[], int n) 
    { 
		int[][] dp = new int[n+1][W+1];
		for(int[] temp: dp) {
			Arrays.fill(temp, -1);
		}
        return solve(n-1, W, wt, val, dp);
    }

	private static int solve(int indx, int W, int[] wt, int[] val, int[][] dp) {
		// base case
		if (indx < 0) {
			return 0;
		}
		
		//memoization check
		if(dp[indx][W] != -1) {
			return dp[indx][W];
		}

		int take = Integer.MIN_VALUE;
		if (wt[indx] <= W) {
			take = val[indx] + solve(indx - 1, W - wt[indx], wt, val, dp);
		}

		int notTake = 0 + solve(indx - 1, W, wt, val, dp);
		return dp[indx][W] = Math.max(take, notTake);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
