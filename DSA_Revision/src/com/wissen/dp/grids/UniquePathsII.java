package com.wissen.dp.grids;

import java.util.Arrays;

public class UniquePathsII {
	
	 //TC: O(m*n)
    //SC: O(m+n) stack space + O(m*n) memoization space
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        //start from the bottom right corner
        return dfs(m-1, n-1, grid, dp);
    }
    
    private int dfs(int i, int j, int[][] grid, int[][] dp) {
        //base cases
        //out of bound
        if(!isValid(i,j,grid)) {
            return 0;
        }
        
        //if there is an obstacle at current grid
        if(grid[i][j] == 1) {
            return 0;
        }
        //reached at the top-left corner
        if(i== 0 & j == 0 && grid[i][j] == 0) {
            return 1;
        }
        
        //memoization check
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int up = dfs(i-1, j, grid, dp);
        int left = dfs(i, j-1, grid, dp);
        
        return dp[i][j] = up + left;
    }
    
    private boolean isValid(int i, int j, int[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
