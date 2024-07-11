package com.wissen.DP;

import java.util.*;
public class HouseRobberII {
	//TC: O(2^n)+ O(n)
	//SC: O(n) stack space + O(n) storage space
	public int rob(int[] nums) {
        int n = nums.length;
        //base case
        if(n == 1) {
            return nums[0];
        }
        
        int[] first = new int[n];
        int[] second = new int[n];
        
        for(int i=0; i<n; i++) {
            if(i != 0) {
                first[i] = nums[i];
            }
            if(i != n-1) {
                second[i] = nums[i];
            }
        }
        int firstExcept = rob1(first);
        int secondExecpt = rob1(second);
        return Math.max(firstExcept, secondExecpt);
    }
    
    public int rob1(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> hmap = new HashMap<>();
        return helper(n-1, nums, hmap);
    }
    
    private int helper(int indx, int[] nums,Map<Integer, Integer> hmap) {
        int key = indx;
        //base case
        if(indx < 0) {
            return 0;
        }
        if(indx == 0) {
            return nums[indx];
        }
        if(hmap.containsKey(key)) {
            return hmap.get(key);
        }
        
        int left = nums[indx] + helper(indx-2, nums, hmap);
        int right = 0 + helper(indx-1, nums, hmap);
        hmap.put(key, Math.max(left, right));
        return Math.max(left, right);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
