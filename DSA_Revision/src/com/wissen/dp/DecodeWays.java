package com.wissen.dp;

import java.util.Arrays;

public class DecodeWays {
	
	public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0, s, n, dp);
    }
    
    private int solve(int indx, String s, int n, int[] dp) {
        //Two base cases
        if(indx == n) { //one valid split is done
            return 1;
        }
        
        if(s.charAt(indx) == '0') { //if curr indx^th char is 0 then split is not possible
            return 0;
        }
        
        if(dp[indx] != -1) {
            return dp[indx];
        }
        
        int op1 = solve(indx+1, s, n, dp);
        int op2 = 0;
        if(indx+1 < n) {
            if(s.charAt(indx) == '1' || (s.charAt(indx) =='2' && s.charAt(indx+1) <= '6')) {
                op2 = solve(indx+2, s, n, dp);
            }
        }
           
        dp[indx] = op1 + op2;
        return dp[indx];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
