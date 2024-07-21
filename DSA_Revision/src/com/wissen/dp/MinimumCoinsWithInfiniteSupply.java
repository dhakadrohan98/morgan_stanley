package com.wissen.dp;

public class MinimumCoinsWithInfiniteSupply {

	//TC: O(2^(m*n)
    //SC: O(n*m) stack space + O(n*m) memoization space
    public static int coinChange(int[] coins, int target) {
		int n = coins.length;
        //declare 2D array long type
        int[][] dp = new int[n+1][target+1];
        for(int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        
        int ans = solve(n - 1, target, coins, dp);
		if(ans == (int)Math.pow(10,9)) {
            return -1;
        }
        return ans;
	}

	private static int solve(int indx, int target, int[] nums, int[][] dp) {
		// base case
		// If T is divisible by the first element of the array, return the quotient
		if (indx == 0) {
			if (target % nums[0] == 0) {
				return target / nums[0];
			} else {
				return (int)Math.pow(10,9);
			}
		}
        
        if(dp[indx][target] != -1) {
            return dp[indx][target];
        }

		int take = (int)Math.pow(10,9);
		if (target >= nums[indx]) {
			take = 1 + solve(indx, target - nums[indx], nums, dp);
		}
		int notTake = 0 + solve(indx - 1, target, nums, dp);
        
		return dp[indx][target] = Math.min(take, notTake);
    }
	
	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int target = 11;
		System.out.println(coinChange(coins, target));
		System.out.println(0 / 1);
		System.out.println(Integer.MAX_VALUE);

	}

}
