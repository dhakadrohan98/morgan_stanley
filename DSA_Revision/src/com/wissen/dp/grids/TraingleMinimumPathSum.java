package com.wissen.dp.grids;

import java.util.*;

public class TraingleMinimumPathSum {
	
	//TC: O(n) reduced due to memoization
    //SC: O(n) stack space + O(n*n) memoization space
    public int minimumTotal(List<List<Integer>> arr) {
        int n = arr.size();
        int[][] dp = new int[n+1][n+1];
        for(int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        return solve(0,0,arr, dp); 
    }
    
    private  int solve(int i, int j, List<List<Integer>> arr, int[][] dp) {
        //base case
        if(i == arr.size() - 1) {
            return arr.get(i).get(j);
        }
        
        //memoization
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int leftSum = arr.get(i).get(j) +  solve(i+1,j,arr, dp);
        int rightSum = arr.get(i).get(j) + solve(i+1,j+1,arr, dp);
        
        return dp[i][j] = Math.min(leftSum, rightSum);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
