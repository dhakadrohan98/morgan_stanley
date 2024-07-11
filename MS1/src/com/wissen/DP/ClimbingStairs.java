package com.wissen.DP;

import java.util.*;
public class ClimbingStairs {

	//TC: < O(2^n)
    //SC: < O(n+n) stack space + hashmap
    public int climbStairs(int n) {
        Map<Integer, Integer> hmap = new HashMap<>();
        return helper(n, hmap);
    }
    
    public int helper(int n, Map<Integer, Integer> hmap) {
        int key = n;
        //base case
        if(n < 0) {
            return 0;
        }
        
        if(n == 1 || n == 0) {
          return 1;  
        }
        
        if(hmap.containsKey(key)) {
            return hmap.get(key);
        }
        
        int oneStep = helper(n-1, hmap);
        int twoStep = helper(n-2, hmap);
        int totalWays = oneStep + twoStep;
        hmap.put(key, totalWays);
        return totalWays;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
