package com.wissen.dp.grids;

import java.util.Arrays;

public class _3dDPChoclatesPickupBy2Robot {
	
	//TC: O(n*m*m) * 9(due to exploring all 9 states)
    //SC: O(n*m*m) memoization dp array + O(n) stack space
    public int solve(int n, int m, int[][] grid) {
        //robot1 -> (0, 0)
        //robot2 -> (0, m-1)
        // rec(i, j1, j2);
        
        //dp array to memoize
        int[][][] dp = new int[n][m][m];
        for(int[][] twoDArr : dp) {
            for(int[] oneDArr : twoDArr) {
                 Arrays.fill(oneDArr, -(int) Math.pow(10, 9));
            }
        }
        return rec(0, 0, m-1, grid, dp);
    }
    
    private int rec(int i, int j1, int j2, int[][] arr, int[][][] dp) {
        //Two base cases
        
        //out of bound base case
        if(j1 < 0 || j1 >= arr[0].length || j2 < 0 || j2 >= arr[0].length) {
            return -(int) Math.pow(10, 9);
        }
        // Reached destination at the same column & different column
        if(i == arr.length - 1) {
            //if both robot reached the same column in last row
            if(j1 == j2) {
                return arr[i][j1];
            } else {
                return arr[i][j1] + arr[i][j2];
            }
        }
        
        //memoization check
        if(dp[i][j1][j2] != -(int) Math.pow(10, 9)) {
            return dp[i][j1][j2];
        }
        
        int maxi = Integer.MIN_VALUE;
        
        //Actual recurrence relations
        //explore all nine paths (-1, 0, 1) -> (-1, 0, 1)
        //for single option of robot1, robot2 has always three options
        for(int dj1 = -1; dj1 <= 1; dj1++) {
            for(int dj2 = -1; dj2 <= 1; dj2++) {
                //if both robot reached the same column of current row
                if(j1 == j2) {
                    maxi = Math.max(maxi, arr[i][j1] + rec(i+1, j1 + dj1, j2 + dj2, arr, dp));
                } else {
                    maxi = Math.max(maxi, arr[i][j1] + arr[i][j2] + rec(i+1, j1 + dj1, j2 + dj2, arr, dp));
                }
            }
        }
        
        return dp[i][j1][j2] = maxi;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
