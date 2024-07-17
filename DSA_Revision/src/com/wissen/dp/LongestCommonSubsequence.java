package com.wissen.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
	//TC: O(2^n)
	//SC: O(n) stack space + O(n) dp storage
	public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int[] temp : dp) {
            Arrays.fill(temp, -1);   
        }
        return rec(text1, text2, n1-1, n2-1, dp);
    }
    
    private int rec(String str1, String str2, int i, int j, int[][] dp) {
        //base case
        if(i < 0 || j < 0) {
            return 0;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        //matched characters
        int left = 0;
        if(str1.charAt(i) == str2.charAt(j)) {
            left = 1 + rec(str1, str2, i-1, j-1, dp);
        }
        //not matched at i  == j
        int right = 0 + Math.max(rec(str1, str2, i-1, j, dp), 
                                 rec(str1, str2, i, j-1, dp));
        
        int maxi = Math.max(left, right);
        dp[i][j] = maxi;
        return dp[i][j];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
