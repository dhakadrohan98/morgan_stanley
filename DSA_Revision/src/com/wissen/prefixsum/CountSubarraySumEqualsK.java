package com.wissen.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraySumEqualsK {
	
	//prefix sum concept
    //TC: O(n)
    //SC: O(n)
    public static int findSubArraySum(int arr[], int n, int k)
    {
        int sum = 0;
        int total = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, 1);
        
        for(int i=0; i<n; i++) {
        	sum += arr[i];
        	int diff = sum - k;
        	if(hmap.containsKey(diff)) {
        		total += hmap.get(diff);
        	}
        	hmap.put(sum, hmap.getOrDefault(sum, 0)+1);
        }
        return total;
    }
	
	public static void main(String[] args) {
		int[] nums = {10, 2, -2, -20, 10};
		System.out.println(findSubArraySum(nums, nums.length, -10));

	}

}
