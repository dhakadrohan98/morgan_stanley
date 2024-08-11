package com.os.test;

import java.util.*;

public class PassTheBall2 {
	private Map<String, Integer> memo = new HashMap<>();

    public int passTheBall2(int input1, int input2, int input3) {
        // input1: Number of players (N)
        // input2: Starting player (P)
        // input3: Maximum moves allowed (X)
        
        return findWays(input1, input2, input2, input3);
    }

    private int findWays(int N, int current, int start, int movesLeft) {
        // Base case: If no moves are left, check if the ball is with the starting player
        if (movesLeft == 0) {
            return current == start ? 1 : 0;
        }

        // Generate a unique key for memoization
        String key = current + "," + movesLeft;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int count = 0;
        // Iterate over all players to find valid passes
        for (int i = 1; i <= N; i++) {
            if (i != current && (current % i == 0 || i % current == 0)) {
                count += findWays(N, i, start, movesLeft - 1);
            }
        }

        // Store the result in memo before returning
        memo.put(key, count);
        return count;
    }

    public static void main(String[] args) {
        PassTheBall2 ptb = new PassTheBall2();

        // Example 1
        System.out.println(ptb.passTheBall2(3, 2, 2)); // Output: 1

        // Example 2
        System.out.println(ptb.passTheBall2(3, 2, 4)); // Output: 3
    }
}
