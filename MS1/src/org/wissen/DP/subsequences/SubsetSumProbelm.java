package org.wissen.DP.subsequences;

import java.util.*;

public class SubsetSumProbelm {
	//TC: O(2^n)
	//SC: O(n^2) dp memoization space + O(n) stack space
	class Solution{
	    static Boolean isSubsetSum(int N, int arr[], int target){
	        int[][] dp = new int[N+1][target+1];
	        for(int[] temp : dp) {
	            Arrays.fill(temp, -1);
	        }
	        int res = dfs(arr, N-1, 0, target, dp);
	        if(res == 1) {
	        	return true;
	        } else {
	        	return false;
	        }
	    }
	    
	    public static int dfs(int[] arr ,int indx, int sum, int target, int[][] dp) {
	        //base cases
	        if(sum == target) {
	            return 1;
	        }
	        if(sum > target || indx < 0) {
	            return 0;
	        }
	        if(dp[indx][sum] != -1) {
	            return dp[indx][sum];
	        }
	        
	        int left  = dfs(arr, indx-1, sum+arr[indx], target, dp);
	        int right = dfs(arr, indx-1, sum, target, dp);
	        if(left == 1 || right == 1) {
	        	dp[indx][sum] = 1;
	        } else {
	        	dp[indx][sum] = 0;
	        }
	        return dp[indx][sum];
	    }
	}
	
	public static void main(String[] args) {
		

	}

}
