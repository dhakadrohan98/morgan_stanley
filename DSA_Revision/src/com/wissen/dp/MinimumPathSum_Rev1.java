package com.wissen.dp;

import java.util.Arrays;

public class MinimumPathSum_Rev1 {

	//TC: O(m*n)
    //SC: O(m*n) memoization space + O(m*n) stack space
    
    public int minPathSum(int[][] grid) {
        int m = grid.length; //rows
        int n = grid[0].length; //cols
        int[][] dp = new int[m+1][n+1];
        for(int[] arr: dp) {
            Arrays.fill(arr, (int) Math.pow(10,9));
        }
        
        return rec(m-1, n-1, grid, dp);
    }
    
    private int rec(int i, int j, int[][] grid, int[][] dp) {
        //base case
        
        if(i == 0 && j == 0) {
            return grid[i][j];
        }
        
        if(i < 0 || j < 0) {
            return (int) Math.pow(10,9);
        }
        
        //memoization check
        if(dp[i][j] != (int) Math.pow(10,9)) {
            return dp[i][j];
        }
        
        int up = grid[i][j] + rec(i-1, j, grid, dp);
        int down = grid[i][j] + rec(i, j-1, grid, dp);
        
        return dp[i][j] = Math.min(up, down);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
