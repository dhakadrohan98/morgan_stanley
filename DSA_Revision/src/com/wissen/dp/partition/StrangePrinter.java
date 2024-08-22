package com.wissen.dp.partition;

import java.util.Arrays;

//TC: O(n^3)
//SC: O(n^2)
public class StrangePrinter {

	int n; // Length of the string
	int[][] t; // Memoization table

	// Recursive function to solve the problem
	public int solve(int l, int r, String s) {
		if (l == r) // Base case: single character
			return 1;

		if (l > r) // Base case: invalid range
			return 0;

		if (t[l][r] != -1) // Check if already computed
			return t[l][r];

		int i = l + 1;
		// Skip all characters that are the same as s[l]
		while (i <= r && s.charAt(i) == s.charAt(l))
			i++;

		// If all characters from l to r are the same
		if (i == r + 1)
			return 1;

		// Normal case: 1 + solve for the rest of the string
		int basic = 1 + solve(i, r, s);

		int lalach = Integer.MAX_VALUE;

		// Try to find a better solution by splitting the string
		for (int j = i; j <= r; j++) {
			if (s.charAt(l) == s.charAt(j)) {
				int ans2 = solve(i, j - 1, s) + solve(j, r, s);
				lalach = Math.min(lalach, ans2);
			}
		}

		// Store the result in the memoization table
		return t[l][r] = Math.min(basic, lalach);
	}

	// Main function to solve the problem
	public int strangePrinter(String s) {
		n = s.length(); // Get the length of the string
		t = new int[n][n + 1]; // Initialize the memoization table
		for (int[] row : t)
			Arrays.fill(row, -1); // Fill the table with -1

		return solve(0, n - 1, s); // Call the recursive function
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
