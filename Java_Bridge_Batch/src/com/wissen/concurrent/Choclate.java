package com.wissen.concurrent;

import java.util.stream.Stream;

public class Choclate {

//    public static int countWays(int N, int k) {
//        // Initialize a 2D array to store the number of ways
//        int[][] dp = new int[N + 1][N + 1];
//
//        // Base case: there is only one way to have one chocolate left
//        for (int i = 1; i <= N; i++) {
//            dp[1][i] = 1;
//        }
//
//        // Fill the DP table
//        for (int i = 2; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                if (j > 1) {
//                    dp[i][j] += dp[i - 1][j - 1];
//                }
//                if (j < N) {
//                    dp[i][j] += dp[i - 1][j + 1];
//                }
//            }
//        }
//
//        // The total number of ways is the value at dp[N][k]
//        return dp[N][k];
//    }
	
    public static int lastElement(int input1, int input2) {
        int N = input1;
        int K = input2;
        
        int[][] dp = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            dp[1][i] = 1;
        }
        
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (j > 1) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j < i) {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        
        return dp[N][K];
    }

    public static void main(String[] args) {
        int N = 5;
        int k = 1;
        System.out.println("Total number of ways: " + lastElement(N, k));
    }
}

