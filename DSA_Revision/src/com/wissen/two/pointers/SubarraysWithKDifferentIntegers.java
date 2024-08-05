package com.wissen.two.pointers;

import java.util.*;
//TC: O(2^n) calling fuc(k), fuc(k-1)
//SC: O(n) hashmap
public class SubarraysWithKDifferentIntegers {
	
	public int subarraysWithKDistinct(int[] nums, int k) {
        int count1 = subarraysLessThanEqualToKDistinct(nums, k);
        int count2 = subarraysLessThanEqualToKDistinct(nums, k-1);
        return count1 - count2;
    }
    
    private int subarraysLessThanEqualToKDistinct(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, count = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        
        while(r < n) {
            hmap.put(nums[r], hmap.getOrDefault(nums[r], 0) + 1);
            
            while(hmap.size() > k) {
                hmap.put(nums[l], hmap.get(nums[l]) - 1);
                if(hmap.get(nums[l]) == 0) {
                    hmap.remove(nums[l]);
                }
                l++;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
