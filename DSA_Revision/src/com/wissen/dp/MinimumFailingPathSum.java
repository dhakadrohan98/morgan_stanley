package com.wissen.dp;

import java.util.Arrays;

public class MinimumFailingPathSum {
	
	 //prev TC: O(3*(m*n)) without memoization
    //TC: O(m*n)
    //SC: O(m*n) memoization space + O(m*n) stack space
    
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length; //rows
        int n = matrix[0].length; //cols
        int mini = Integer.MAX_VALUE;
        
        int[][] dp = new int[m+1][n+1];
            for(int[] dpArr: dp) {
                Arrays.fill(dpArr, (int) Math.pow(10,9));
            }
        
        for(int j = 0; j < n; j++) {
            int res = rec(0, j, matrix, dp);
            mini = Math.min(mini, res);
        }
        return mini;
    }
    
    private int rec(int i, int j, int[][] arr, int[][] dp) {
        //base cases
        if(j < 0 || j >= arr[0].length) {
            return (int) Math.pow(10,9);
        }
        
        if(i == arr.length - 1) {
            return arr[i][j];
        }
        
        if(dp[i][j] != (int) Math.pow(10,9)) {
            return dp[i][j];
        }
        
        //We have three options for cols & row always will be next one.
        int nextRowPrevIndex = arr[i][j] + rec(i+1, j-1, arr, dp);
        int nextRowSameIndex = arr[i][j] + rec(i+1, j, arr, dp);
        int nextRowNextIndex = arr[i][j] + rec(i+1, j+1, arr, dp);
        
        return dp[i][j] = Math.min(nextRowPrevIndex, Math.min(nextRowSameIndex, nextRowNextIndex));
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
