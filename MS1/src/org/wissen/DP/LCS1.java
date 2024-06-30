package org.wissen.DP;

import java.util.Arrays;

public class LCS1 {

//	public int longestCommonSubsequence(String text1, String text2) {
//        int n1 = text1.length();
//        int n2 = text2.length();
//        int indx1 = n1 - 1;
//        int indx2 = n2 - 1;
//        StringBuilder backtrack = new StringBuilder();
//        int[][] dp = new int[n1+1][n2+1];
//        for(int[] temp: dp) {
//            Arrays.fill(temp, -1);
//        }
//        
//        return helper(indx1, indx2, text1, text2, dp, backtrack);
//    }
//    
//    private int helper(int indx1,int indx2,String text1,String text2,int[][] dp,String backtrack ) {
//        //base case
//        if(indx1 < 0 || indx2 < 0) {
//            return 0;
//        }
//        
//        if(dp[indx1][indx2] != -1) {
//            return dp[indx1][indx2];
//        }
//        
//        int include = 0;
//        if(text1.charAt(indx1) == text2.charAt(indx2)) {
//            include = 1 + helper(indx1-1, indx2-1, text1, text2, dp);
//            backtrack +
//        }
//        int exclude = 0 + Math.max(helper(indx1-1, indx2, text1, text2, dp), helper(indx1, indx2-1, text1, text2, dp));
//        
//        dp[indx1][indx2] = Math.max(include, exclude);
//        return Math.max(include, exclude);
//    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
