package com.wissen.DSAproblems;

import java.util.*;

public class CountSubarraySumEqualsK {

	// TC: O(n)
	// SC: O(n)
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		int n = nums.length;
		int prefix = 0;
		int totalCount = 0;
		hmap.put(0, 1);

		for (int i = 0; i < n; i++) {
			prefix += nums[i];
			if (hmap.containsKey(prefix - k)) {
				totalCount += hmap.get(prefix - k);
			}
			hmap.put(prefix, hmap.getOrDefault(prefix, 0) + 1);
		}
		return totalCount;
	}
//	
//	1
//	1 2
//	1 2 3
//	1 2 3 4
//	
//	2
//	2 3
//	2 3 4
//	
//	3
//	3,4
//	
//	4
//1,2,3,4
	                  //prefix - k
// k = 3	
//	[1,3,6,10]  {{0,1},
//				{1,1}, {3,1}, {6,1}, {7,1}
//	
//	prefix = 6
//			count = 1
			
	
	
	
	
//	//1,2,3,4
//	sum = 1,3,6,10
//	sum = 2,5
//	sum= 3
//	
//	
//	i=0, j=0 sum += nums[0]
//		 j=1, sum += nums[1]
//		 j=2, sum+= nums[2]
//	     j=3, sum+= nums[3]
//		 sum=0;
//				 
//	i=1, j=1 sum = 2
//			j=2, sum=

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
