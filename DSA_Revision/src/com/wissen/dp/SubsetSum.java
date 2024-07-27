package com.wissen.dp;

import java.util.Arrays;

public class SubsetSum {
	
	//TC: O(2^(N*Sum))
    //SC: O(N+SUM) stack space + O(N*SUM) memoization space
    static Boolean isSubsetSum(int n, int arr[], int sum){
        int[][] dp = new int[n+1][sum+1];
        for(int[] temp: dp) {
            Arrays.fill(temp,-1);
        }
        return solve(n-1, sum, arr, dp);
    }
    
    static Boolean solve(int indx, int sum, int[] arr, int[][] dp) {
        //base cases
        if(sum == 0) {
            return true;
        }
        
        if(sum < 0 || indx < 0) {
            return false;
        }
        
        if(dp[indx][sum] != -1) {
            if(dp[indx][sum] == 1) {
                return true;
            } else {
                return false;
            }
        }
        
        //include
        boolean leftRec = solve(indx-1, sum-arr[indx], arr, dp);
        //exclude
        boolean rightRec = solve(indx-1, sum, arr, dp);
        
        boolean res = leftRec || rightRec;
        if(res == true) {
            dp[indx][sum] = 1;
        } else {
            dp[indx][sum] = 0;
        }
        return leftRec || rightRec;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
