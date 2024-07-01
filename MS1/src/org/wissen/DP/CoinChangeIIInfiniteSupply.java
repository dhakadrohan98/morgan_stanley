package org.wissen.DP;

import java.util.*;
public class CoinChangeIIInfiniteSupply {

	public int change(int target, int[] nums) {
        int n = nums.length;
        Map<String, Integer> hmap = new HashMap<>();
        return helper(n-1, target, nums, hmap);
    }
    
    public int helper(int indx, int target, int[] nums, Map<String, Integer> hmap) {
        String key = indx+"_"+target;
        //base case  
        if(target == 0) {
            return 1;
        }
        if(indx < 0) {
            return 0;
        }
        if(hmap.containsKey(key)) {
            return hmap.get(key);
        }
        
        int left = 0;
        if(target >= nums[indx]) {
            left = helper(indx, target-nums[indx], nums, hmap);
        }
        int right = helper(indx-1, target, nums, hmap);
        hmap.put(key, left+right);
        return left + right;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
