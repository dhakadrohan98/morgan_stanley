package com.wissen.DSAproblems;

import java.util.*;

// using hashmap
public class LongestCommonSubsequenceUsingHashMap {

	//TC: O(2^n)
    //SC: O(n)
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 =text1.length();
        int n2 = text2.length();
        Map<String, Integer> hmap = new HashMap<>();
        return helper(n1-1, n2-1, text1, text2, hmap);
    }
    
    private int helper(int indx1, int indx2, String str1, String str2, Map<String, Integer> hmap) {
        
        String key = indx1+"_"+indx2;
        //base case
        if(indx1 < 0 || indx2 < 0) {
            return 0;
        }
        //memoization check
        if(hmap.containsKey(key)) {
            return hmap.get(key);
        }
        
        int left = 0;
        if(str1.charAt(indx1) == str2.charAt(indx2)) {
            left = 1 + helper(indx1-1, indx2-1, str1, str2, hmap);
        }
        int right = 0 + Math.max(helper(indx1-1, indx2, str1, str2, hmap),
                                helper(indx1, indx2-1, str1, str2, hmap));
        
        int max = Math.max(left, right);
        hmap.put(key, max);
        return max;
    }
}
