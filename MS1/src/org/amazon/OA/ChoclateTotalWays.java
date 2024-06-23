package org.amazon.OA;

public class ChoclateTotalWays {
	//TC: O(N^2)
	//SC: O(N^2)
	public static void main(String[] args) {
        int N = 5; // Number of chocolates
        int k = 1; // The target index of the remaining chocolate
        System.out.println(lastElement(N, k));
    }

    public static int lastElement(int N, int k) {
        if (k < 1 || k > N) {
            return 0;
        }

        // Create a DP table to store the number of ways
        int[][] dp = new int[N + 1][N + 1];

        // Base case: 1 way to have 1 chocolate remaining at position k
        for (int i = 1; i <= N; i++) {
            dp[1][i] = 1;
        }

        // Fill the DP table
        for (int remaining = 2; remaining <= N; remaining++) {
            for (int pos = 1; pos <= N; pos++) {
                dp[remaining][pos] = 0;
                if (pos > 1) {
                    dp[remaining][pos] += dp[remaining - 1][pos - 1]; // Remove from start
                }
                if (pos < remaining) {
                    dp[remaining][pos] += dp[remaining - 1][pos]; // Remove from end
                }
            }
        }

        // The answer is the number of ways to have the kth chocolate as the last one remaining
        return dp[N][k];
    }
}
