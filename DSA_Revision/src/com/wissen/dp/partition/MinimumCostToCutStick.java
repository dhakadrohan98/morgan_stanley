package com.wissen.dp.partition;

import java.util.Arrays;

//TC: O(c^3), c -> length of cuts stick array
//SC O(c^2) + O(c)

public class MinimumCostToCutStick {

	static int max = (int) 10e9;

	public static int minCost(int n, int[] cuts) {
		//insert 0 & n at new sized array first & last index along with cuts arrays values
		int len = cuts.length + 2;
		int[] arr = new int[len];
		arr[0] = 0;
		arr[len - 1] = n;
		int k = 0;

		for (int i = 1; i < arr.length - 1; i++) {
			if (k < cuts.length) {
				arr[i] = cuts[k++];
			}
		}

		// sort the newly formed array
		Arrays.sort(arr);
		int cutsLen = cuts.length;
		//memoizatoin dp array building
		int[][] dp = new int[cutsLen + 1][cutsLen + 1];
		for (int[] temp : dp) {
			Arrays.fill(temp, max);
		}

		System.out.println("i: " + 1 + ", j: " + cuts.length);
		// partition range will be from 1 to cuts.length
		return fun(1, cuts.length, arr, n, dp);
	}

	private static int fun(int i, int j, int[] arr, int n, int[][] dp) {
		// base case
		// not cut is possible on given partition
		if (i > j) {
			return 0;
		}

		// memoization check
		if (dp[i][j] != max) {
			return dp[i][j];
		}

		int mini = Integer.MAX_VALUE;
		for (int indx = i; indx <= j; indx++) {
			int cost = arr[j + 1] - arr[i - 1] + fun(i, indx - 1, arr, n, dp) + fun(indx + 1, j, arr, n, dp);

			mini = Math.min(mini, cost);
		}
		return dp[i][j] = mini;
	}

	public static void main(String[] args) {
		int[] cuts = {1,3,4,5};
		int n = 7;
		
		System.out.println(minCost(n, cuts));
	}
}
