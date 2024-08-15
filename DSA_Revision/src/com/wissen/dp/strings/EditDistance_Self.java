package com.wissen.dp.strings;

import java.util.Arrays;

public class EditDistance_Self {
	
	public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] temp: dp) {
            Arrays.fill(temp, -1); 
        }
        return solve(n-1, m-1, s1, s2, dp);
    }
    
    private int solve(int i, int j, String s1, String s2, int[][] dp) {
        //Three base cases
        //if any index ran out of bound
        if(i < 0) {
            return j+1;
        }
        
        if(j < 0) {
            return i+1;
        }
        
        if(s1.charAt(i) == s2.charAt(j)) {
            return solve(i-1, j-1, s1, s2, dp);
        }
        
        //if memoization check
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        //we have three option insert, delete, replace
        int replace = 1 + solve(i-1, j-1, s1, s2, dp);
        int delete = 1 + solve(i-1, j, s1, s2, dp);
        int insert = 1 + solve(i, j-1, s1, s2, dp);
        
        int minStep = Math.min(replace, Math.min(delete, insert));
        return dp[i][j] = minStep;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
