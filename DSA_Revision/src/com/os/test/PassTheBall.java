package com.os.test;

import java.util.*;
public class PassTheBall {
	public int passTheBall(int N, int P, int X) {
        // Memoization map to store results of subproblems
        Map<String, Integer> memo = new HashMap<>();
        return countWays(N, P, X, P, memo);
    }

    private int countWays(int N, int current, int movesLeft, int start, Map<String, Integer> memo) {
        // Base case: if no moves left, check if the ball is with the starting player
        if (movesLeft == 0) {
            return current == start ? 1 : 0;
        }

        // Create a unique key for memoization
        String key = current + "," + movesLeft;

        // Check if the result is already computed
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ways = 0;

        // Try passing the ball to each player
        for (int next = 1; next <= N; next++) {
            if (next != current && (current % next == 0 || next % current == 0)) {
                ways += countWays(N, next, movesLeft - 1, start, memo);
            }
        }

        // Store the result in the memoization map
        memo.put(key, ways);

        return ways;
    }

    public static void main(String[] args) {
        PassTheBall game = new PassTheBall();
        System.out.println(game.passTheBall(3, 2, 2)); // Output: 1
        System.out.println(game.passTheBall(3, 2, 4)); // Output: 3
    }
}
