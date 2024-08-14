package com.wissen.dp.grids;

import java.util.Arrays;

public class MinimumFailingPathSum {
	
	//TC: O(m*n)
    //SC: O(n) stack space + O(m*n) memoization dp array
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp =  new int[n][m];
        for(int[] temp: dp) {
            Arrays.fill(temp, (int) Math.pow(10,9));
        }
        
        int mini = Integer.MAX_VALUE;
        // For each starting column, find the minimum path sum and update mini
        for(int j=0; j<m; j++) {
           int ans =  dfs(n-1, j, mat, dp);
           mini = Math.min(ans, mini);
        }
        return mini;
    }
    
    private int dfs(int i, int j, int[][] mat, int[][] dp) {
        //base cases
        //diagonally  go out of bound from both col side
        if(j < 0 || j >= mat[0].length) {
            return (int) Math.pow(10,9);
        }
        //reached last row
        if(i == 0) {
            return mat[0][j];
        }
        
        //memoizatio check
        if(dp[i][j] != (int) Math.pow(10,9)) {
            return dp[i][j];
        }
        
        int s = mat[i][j] + dfs(i-1, j, mat, dp);
        int ld = mat[i][j] + dfs(i-1, j-1, mat, dp);
        int rd = mat[i][j] + dfs(i-1, j+1, mat, dp);
        
        int resMin = Math.min(s, Math.min(ld, rd));
        return dp[i][j] = resMin;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
