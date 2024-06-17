package com.wissen;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

	//TC: < O(2^n * 2^n) + O(n) & SC: O(n * n) 
	public int longestPalindromeSubseq(String s) {
        //reverse a given string
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=n-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        String sRev = sb.toString();
        
        return longestCommonSubsequence(s, sRev);
        
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];
        
        for(int[] arr:dp) {
            Arrays.fill(arr,-1);
        }
        
        int indx1 = n1 - 1;
        int indx2 = n2 - 1;
        
        return helper(text1, text2, indx1, indx2, dp);
    }
    
    private int helper(String text1, String text2,int indx1, int indx2, int[][] dp) {
        //base case
        if(indx1 < 0 || indx2 < 0) {
            return 0;
        }
        if(dp[indx1][indx2] != -1) {
            return dp[indx1][indx2];
        }
        
        if(text1.charAt(indx1) == text2.charAt(indx2)) {
            int matches = 1 + helper(text1, text2, indx1-1, indx2-1, dp);
            dp[indx1][indx2] = matches;
            return matches;
        }
        else {
            int notMatches = 0 + Math.max( helper(text1, text2, indx1-1, indx2, dp), helper(text1, text2, indx1, indx2-1, dp) );
            dp[indx1][indx2] = notMatches;
            return notMatches;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
