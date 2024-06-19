package org.wissen.DP;

import java.util.*;

public class LongestCommonSubsequence {

	//TC: < O(2^n * 2^m)
    //SC: < O(n * m)
    public int longestCommonSubsequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int indx1 = str1.length() -1;
        int indx2 = str2.length() - 1;
        int[][] dp = new int[n1+1][n2+1];
        //fill dp[][] with -1
        for(int[] temp: dp) {
            Arrays.fill(temp, -1);
        }
        
        return helper(str1, str2, indx1, indx2, dp);
    }
    
    public int helper(String str1, String str2, int indx1, int indx2, int[][] dp) {
        //base case
        if(indx1 < 0 || indx2 < 0) {
            return 0;
        }
        
        if(dp[indx1][indx2] != -1) {
            return dp[indx1][indx2];
        }
        
        int include = 0;
        if(str1.charAt(indx1) == str2.charAt(indx2)) {
            include = 1 + helper(str1, str2, indx1-1, indx2-1, dp);
        }
        int exclude = 0 + Math.max(helper(str1, str2, indx1-1, indx2, dp), helper(str1, str2, indx1, indx2-1, dp));
        dp[indx1][indx2] = Math.max(include, exclude);
        return Math.max(include, exclude);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
