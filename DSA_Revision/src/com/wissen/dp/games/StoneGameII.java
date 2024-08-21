package com.wissen.dp.games;

import java.util.Arrays;

//T.C : O(n^3) + stack space
//S.C : O(n^3)
public class StoneGameII {

	private int n;

	private int solveForAlice(int[] piles, int person, int i, int M, int[][][] dp) {
		if (i >= n) {
			return 0;
		}

		if (dp[person][i][M] != -1) {
			return dp[person][i][M];
		}

		// 1 -> Alice (result = -1) , 0-> Bob (result = Integer.MAX_VALUE)
		int result = (person == 1) ? -1 : Integer.MAX_VALUE;
		int stones = 0;

		for (int x = 1; x <= Math.min(2 * M, n - i); x++) {
			stones += piles[i + x - 1];

			if (person == 1) { // Alice
				result = Math.max(result, stones + solveForAlice(piles, 0, i + x, Math.max(M, x), dp));
			} else { // Bob
				result = Math.min(result, solveForAlice(piles, 1, i + x, Math.max(M, x), dp));
			}
		}

		return dp[person][i][M] = result;
	}

	public int stoneGameII(int[] piles) {
		n = piles.length;

		int[][][] dp = new int[2][101][101]; // t[2][n+1][n+1] ~ O(n^3)
		// memoization array
		for (int[][] arr2D : dp) {
			for (int[] arr1D : arr2D) {
				Arrays.fill(arr1D, -1);
			}
		}

		return solveForAlice(piles, 1, 0, 1, dp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
