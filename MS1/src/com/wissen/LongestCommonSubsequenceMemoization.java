package com.wissen;

import java.util.*;

// using hashmap
public class LongestCommonSubsequenceMemoization {

	public int longestCommonSubsequence(String text1, String text2) {
        Map<String, Integer> hmap = new HashMap<>();
        int indx1 = text1.length() - 1;
        int indx2 = text2.length() - 1;
        
        return helper(text1, text2, indx1, indx2, hmap);
    }
    
    private int helper(String text1, String text2,int indx1, int indx2,
                      Map<String, Integer> hmap) {
        
        String key = indx1+""+indx2;
        //base case
        if(indx1 < 0 || indx2 < 0) {
            return 0;
        }
        if(hmap.containsKey(key)) {
            hmap.get(key);
        }
        
        if(text1.charAt(indx1) == text2.charAt(indx2)) {
            int matches = 1 + helper(text1, text2, indx1-1, indx2-1, hmap);
            hmap.put(key, matches);
            return matches;
        }
        else {
            int notMatches = 0 + Math.max( helper(text1, text2, indx1-1, indx2, hmap), helper(text1, text2, indx1, indx2-1, hmap) );
            hmap.put(key, notMatches);
            return notMatches;
        }
    }
}
