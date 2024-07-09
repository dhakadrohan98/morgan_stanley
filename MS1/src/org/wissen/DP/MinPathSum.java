package org.wissen.DP;

import java.util.Arrays;

public class MinPathSum {
	public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //declare 2d dp array
        int[][] dp = new int[m+1][n+1];
        for(int[] temp: dp) {
            Arrays.fill(temp, -1);
        }
        
        int min = helper(m-1, n-1, grid, dp);
        return min;
    }
    
    private int helper(int i, int j, int[][] grid, int[][] dp) {
        String key = i+"_"+j;
        //base case
        if(i == 0 && j == 0) {
            return grid[0][0];
        }
        
        if(i < 0 || j < 0) {
            return (int) Math.pow(10,8);
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        //up side
        int up = grid[i][j] + helper(i-1, j, grid, dp);
        //left side
        int left = grid[i][j] + helper(i, j-1, grid, dp);
        int minVal = Math.min(up, left);
        dp[i][j] = minVal;
        return minVal;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
