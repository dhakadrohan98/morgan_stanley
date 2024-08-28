package com.wissen.math;

import java.util.Arrays;

public class _2KeysKeyboard {
	
	//TC: O(n)
	//SC: O(n) recursion stack space + O(n*n) memoization space
	public int minSteps(int n) {
        //edge case
        if(n == 1) {
            return 0;
        }
        //DP
        int[][] dp  = new int[n+1][n+1];
        for(int[] temp : dp) {
            Arrays.fill(temp, 100000);
        }   
        //initially 1 operation to paste 'A' from screen to clipboard
        return 1 + solve(1, 1, n, dp);
    }
    
    private int solve(int currA, int clipA, int n, int[][] dp) {
        //base cases
        //we got n characters on screen 
        if(currA == n) {
            return 0;
        }
        //no. of A's is greater than n
        if(currA > n) {
            return 100000;
        }
        
        //memoization check
        if(dp[currA][clipA] != 100000) {
            return dp[currA][clipA];
        }
        
        int copyAllPaste = 1 + 1 + solve(currA + currA, currA, n, dp);
        int paste = 1 + solve(currA + clipA, clipA, n, dp);
        
        return dp[currA][clipA] = Math.min(copyAllPaste, paste);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
