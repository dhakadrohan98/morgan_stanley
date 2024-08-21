package com.wissen.dp;

import java.util.*;
public class HouseRobber_HashMap {
	
	 //TC: O(2^n)
    //SC: O(n) stack space + O(n) hashmap memoization
    public int rob(int[] nums) {
        int n =  nums.length;
        //memoization using hashmap
        Map<Integer, Integer> hmap = new HashMap<>();
        return rec(n-1, nums, hmap);
    }
    
    private int rec(int indx, int[] nums, Map<Integer, Integer> hmap) {
        //base case
        if(indx < 0) {
            return 0;
        }
        
        //memoization check
        int key = indx;
        if(hmap.containsKey(indx)) {
            return hmap.get(indx);
        }
        
        //pick
        int pick = nums[indx] + rec(indx-2, nums, hmap);
        //not pick
        int notPick = rec(indx-1, nums, hmap);
        int maxi = Math.max(pick, notPick);
        hmap.put(indx, maxi);
        return maxi;
        
    } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
