package com.wissen.dp.strings;

import java.util.*;

public class WildCardMatching_Hard {
	
	//TC: O(2^(m*n)) Exponential
	//SC: O(m*n) memoization check + O(m+n) space check
	public boolean isMatch(String s, String p) {
        int i = p.length();
        int j = s.length();
        Map<String, Boolean> hmap = new HashMap<>();
        return dfs(i-1, j-1, p, s, hmap);
    }
    
    private boolean dfs(int i, int j, String s1, String s2, Map<String, Boolean> hmap) {
        //key for hashmap
        String key = i+"_"+j;
        
        //base cases
        //s1 & s2 has both has exhausted
        if(i < 0 && j < 0) {
            return true;
        }
        //pattern matching string(s1) is exhausted
        if(i < 0 && j >= 0) {
            return false;
        }
        //if s2 is empty string & all characters in s1 has to be all * characters only, then return true otherwise false
        if(j < 0 && i >= 0) {
            return isAllStars(i, s1);
        }
        
        //memoization check
        if(hmap.containsKey(key)) {
            return hmap.get(key);
        }
        
        //if both ith & jth character are matched
        if(s1.charAt(i) == s2.charAt(j) || (s1.charAt(i) == '?')) {
            boolean ans = dfs(i-1, j-1, s1, s2, hmap);
            hmap.put(key, ans);
            return ans;
        }
        
        //match with zero character, move i pointer one step back or match with one character & pointer will remain at * character in s1
        if(s1.charAt(i) == '*') {
            boolean ans = dfs(i-1, j, s1, s2, hmap) || dfs(i, j-1, s1, s2, hmap);
            hmap.put(key, ans);
            return ans;
        }
        
        hmap.put(key, false);
        return false;
    }
    
    private boolean isAllStars(int i, String s1) {
        for(int k = 0; k <= i; k++) {
            if(s1.charAt(k) != '*') {
                return false;
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
