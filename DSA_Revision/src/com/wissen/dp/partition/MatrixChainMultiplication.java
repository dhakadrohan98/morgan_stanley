package com.wissen.dp.partition;

import java.util.Arrays;

//TC:  < O(N*N  * N(for loop)) = O(N^3)
//SC: O(N^2) dp array + O(N) stack space

public class MatrixChainMultiplication {

	static int MAX = (int) Math.pow(10, 9);

	static int matrixMultiplication(int n, int[] arr) {
		int i = 1;
		int j = n - 1;
		int[][] dp = new int[n + 1][n + 1];
		for (int[] temp : dp) {
			Arrays.fill(temp, MAX);
		}
		//return the minimum multiplications to multiply matrix 1 -> matrix 4
		return fuc(arr, i, j, dp);
	}

	static int fuc(int[] arr, int i, int j, int[][] dp) {

		// base condition
		// It will be single matrix. 0 partition will be required due to shrinking of partition.
		if (i == j) {
			return 0;
		}
		// memoization check
		if (dp[i][j] != MAX) {
			return dp[i][j];
		}

		int mini = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {
			// (a,b) (c,d) -> operation caculations for their combining + recursive call to calculate
			//operations for left & right partition(sub problems)
			int ans = arr[i - 1] * arr[k] * arr[j] + fuc(arr, i, k, dp) + fuc(arr, k + 1, j, dp);
			mini = Math.min(mini, ans);
		}
		return dp[i][j] = mini;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
