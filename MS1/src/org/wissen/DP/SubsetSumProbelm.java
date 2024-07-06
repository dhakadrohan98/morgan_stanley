package org.wissen.DP;

import java.util.*;

public class SubsetSumProbelm {
	//TC: O(2^n)
	//SC: O(n) dp memoization space + O(n) stack space
	class Solution{
	    static Boolean isSubsetSum(int N, int arr[], int target){
	        boolean[][] dp = new boolean[N+1][target+1];
	        for(boolean[] temp : dp) {
	            Arrays.fill(temp, true);
	        }
	        return dfs(arr, N-1, 0, target, dp);
	    }
	    
	    public static boolean dfs(int[] arr ,int indx, int sum, int target, boolean[][] dp) {
	        //base cases
	        if(sum == target) {
	            return true;
	        }
	        if(sum > target || indx < 0) {
	            return false;
	        }
	        if(dp[indx][sum] == false) {
	            return dp[indx][sum];
	        }
	        
	        boolean left  = dfs(arr, indx-1, sum+arr[indx], target, dp);
	        boolean right = dfs(arr, indx-1, sum, target, dp);
	        boolean result = left || right;
	        dp[indx][sum] = result;
	        return result;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
