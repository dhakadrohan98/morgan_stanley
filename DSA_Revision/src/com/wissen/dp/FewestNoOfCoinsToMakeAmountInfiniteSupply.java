package com.wissen.dp;

import java.util.Arrays;

public class FewestNoOfCoinsToMakeAmountInfiniteSupply {
	
	 //TC: O(2^(n * amount))
    //SC: O(n+amount) stack space + O(n * amount) memoization space
    
    final int max = (int)Math.pow(10,7);
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        
        int ans = solve(n-1, amount, coins, dp);
        if(ans == max) {
            return -1;
        }
        return ans;
    }
    
    private int solve(int indx, int target, int[] coins, int[][] dp) {
        //base case
        if(indx == 0) {
            if(target % coins[indx] == 0) {
                return target / coins[indx];
            } else {
                return max;
            }
        }
        
        //memoization check
        if(dp[indx][target] != -1) {
            return dp[indx][target];
        }
        
        int take = (int)Math.pow(10,7);
        if(coins[indx] <= target) {
            take = 1 + solve(indx, target - coins[indx], coins, dp);
        }
        int notTake = 0 + solve(indx-1, target, coins, dp);
        return dp[indx][target] = Math.min(take, notTake);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
