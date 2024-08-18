package com.wissen.dp.grids;

import java.util.Arrays;

public class MaximumNumberOfPointsWithCost_IterativeSolution_TLE {

	// Approach-1 - TLE - Just applying concept of Leetcode-931 (Minimum Falling Path Sum)
	// T.C : O(m*n*n)
	// S.C : O(n)
	public static long maxPoints(int[][] points) {
		int m = points.length;
		int n = points[0].length;
		long[] prev = new long[n];

		// Initialize the first row
		for (int col = 0; col < n; col++) {
			prev[col] = points[0][col];
		}

		// Iterate over each row starting from the second one
		for (int i = 1; i < m; i++) {
			long[] curr = new long[n];
			Arrays.fill(curr, Long.MIN_VALUE);

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					curr[j] = Math.max(curr[j], prev[k] + points[i][j] - Math.abs(k - j));
				}
			}
			prev = curr;
		}

		// Find the maximum value in the last processed row
		long max = Long.MIN_VALUE;
		for (long val : prev) {
			max = Math.max(max, val);
		}

		return max;
	}

	public static void main(String[] args) {
		int[][] points = { { 1, 2, 3 }, { 1, 5, 1 }, { 3, 1, 1 } };
		System.out.println(maxPoints(points)); // Output: 9

	}

}
