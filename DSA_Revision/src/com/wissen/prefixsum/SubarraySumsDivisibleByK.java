package com.wissen.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
	
	//TC: O(n)
    //SC: O(n)
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        //<Remainder, Frequency>
        Map<Integer, Integer> hmap = new HashMap<>();
        //Initially sum is 0 & hence remainder is also 0, hence store frequency of 0 into hmap if till p[j] is completely divisible by k.
        
        hmap.put(0,1);
        int sum = 0;
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            
            int rem = sum % k;
            
            if(rem < 0) {
                rem += k;
            }
            
            if(hmap.containsKey(rem)) {
                count += hmap.get(rem);
            }
            
            hmap.put(rem, hmap.getOrDefault(rem, 0) + 1);
        }
        
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
