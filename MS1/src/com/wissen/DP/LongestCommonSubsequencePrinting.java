package com.wissen.DP;

import java.util.*;

public class LongestCommonSubsequencePrinting {
	//Bottom - up approach
	//tabualtion
	// TC: < O(n * m)
    // SC: < O(n * m)
    public static int longestCommonSubsequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        // Fill dp[][] array
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        System.out.println("DP  table");
        for(int i=0; i <= n1; i++) {
        	for(int j=0; j<= n2; j++) {
        		System.out.print(dp[i][j]+" ");
        	}
        	System.out.println();
        }
        
        // To store the LCS string
        //backtrack in DP table
        //TC: O(m+n) at the worst case
        List<Character> lcs = new ArrayList<>();
        int i = n1, j = n2;
        while (i > 0 && j > 0) {	
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.add(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        Collections.reverse(lcs);
        System.out.println("LCS: " + lcs);

        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "bdgek";
        
        String str3 = "AGTGATG";
        String str4 = "GTTAG";
        System.out.println("Length of LCS: " + longestCommonSubsequence(str3, str4));
    }
}
