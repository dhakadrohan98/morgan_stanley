package com.wissen.hashmap;

import java.util.*;
public class KDiffPairs {
	
	//TC: O(2n)
    //SC: O(n)
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 && nums[0] != k) {
            return 0;
        }
        Map<Integer, Integer> hmap = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }
        
        int count = 0;
        
        for(int key: hmap.keySet()) {
            if(k == 0 && hmap.get(key) > 1) {
                count++;
            } else {
              int desired = key+k;
                if(k > 0 && hmap.containsKey(desired)) {
                    count++;
                } 
            }
            
        }
        return count;
    }
    
	public static void main(String[] args) {
		int[] nums1 = {3,1,4,1,5,2}; // 2
		int[] nums2 = {1,3,1,5,4,0}; // 1

	}

}
