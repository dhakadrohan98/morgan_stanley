package org.wissen.DP;

import java.util.*;

public class CoinChangeInfiniteSupply {

	public long count(int coins[], int n, int target) {
        long[][] dp = new long[n+1][target+1];
        for(long[] temp: dp) {
            Arrays.fill(temp, -1);
        }
        
        return helper(coins, n-1, target, dp);
    }
    
    public long helper(int[] coins, int indx, int target, long[][] dp) {
        
        //base case
        if(indx == 0) {
            if(target % coins[0] == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
        
        if(dp[indx][target] != -1) {
            return dp[indx][target];
        }
        
        long take = 0;
        if(coins[indx] <= target) {
            take = helper(coins, indx, target - coins[indx], dp);
        }
        long notTake = helper(coins, indx-1, target, dp);
        
        return dp[indx][target] = take + notTake;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
