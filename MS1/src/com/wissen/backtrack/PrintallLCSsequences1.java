package com.wissen.backtrack;

import java.util.*;
public class PrintallLCSsequences1 {
	
	public List<String> all_longest_common_subsequences(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Use memoization to store intermediate results
        Map<String, Set<String>> memo = new HashMap<>();
        Set<String> lcsSet = backtrack(dp, s, t, m, n, memo);

        // Convert set to list and sort lexicographically
        List<String> result = new ArrayList<>(lcsSet);
        Collections.sort(result);
        return result;
    }

    private Set<String> backtrack(int[][] dp, String s, String t, int i, int j, Map<String, Set<String>> memo) {
        if (i == 0 || j == 0) {
            Set<String> baseSet = new HashSet<>();
            baseSet.add("");
            return baseSet;
        }

        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        Set<String> result = new HashSet<>();
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            Set<String> temp = backtrack(dp, s, t, i - 1, j - 1, memo);
            for (String str : temp) {
                result.add(str + s.charAt(i - 1));
            }
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                result.addAll(backtrack(dp, s, t, i - 1, j, memo));
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                result.addAll(backtrack(dp, s, t, i, j - 1, memo));
            }
        }

        memo.put(key, result);
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
