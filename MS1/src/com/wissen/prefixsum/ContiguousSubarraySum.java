package com.wissen.prefixsum;

import java.util.*;

public class ContiguousSubarraySum {
	  //TC: O(n)
	  //SC: O(n)
	  public static boolean checkSubarraySum(int[] nums, int k) {
	        int prefixSum =0;
	        Map<Integer, Integer> hmap = new HashMap<>();
	        hmap.put(0, -1);
	        int n = nums.length;
	        for(int j=0; j<n; j++) {
	            prefixSum += nums[j];
	            //store prefixSum % k into prefixSum instead of prefixSum += nums[itr]
//	            prefixSum = prefixSum %  k;
	            int mod = prefixSum % k;
	            if(hmap.containsKey(mod)) {
	            	if(j - hmap.get(mod) >= 2) {
	            		System.out.println(hmap);
	            		return true;
	            	}
	            } else {
	            	hmap.put(mod, j);
	            }
	        }
	        System.out.println(hmap);
	        return false;
	    }

	public static void main(String[] args) {
		int[] nums = { 23, 2, 4, 6, 7 };
		int k = 6;

		int[] nums1 = { 23, 2, 6, 4, 7 };
		int k1 = 13;
		System.out.println(checkSubarraySum(nums1, k1));
	}
}

//code by me:
//public static boolean checkSubarraySum(int[] nums, int k) {
//	int n = nums.length;
//	int[] prefix = new int[n];
//	int sum = 0;
//
//	Map<Integer, Integer> mp = new HashMap<>();
//	mp.put(0, -1); // Initialize with cumulative sum 0 at index -1
//
//	for (int i = 0; i < n; i++) {
//		sum += nums[i];
//		if (k != 0) {
//			sum %= k; // Calculate remainder
//		}
//		if (mp.containsKey(sum)) {
//			if (i - mp.get(sum) >= 2) {
//				// Found a good subarray
//				return true;
//			}
//		} else {
//			mp.put(sum, i);
//		}
//	}
//	return false;
//}
