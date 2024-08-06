package com.wissen.hashmap;

import java.util.*;
public class KDiffPairs_Using_Set {
	
	// 54_60 test cases passed
	public static int findPairs(int[] arr, int k) {
        int n = arr.length;
	   // Map<Integer, Integer> hmap = new HashMap<>();
	    Set<Integer> set = new LinkedHashSet<>();
	    
	    for(int i=0; i<n; i++) {
	        set.add(arr[i]);
	    }
	    
	   // for(int i=0; i<n; i++) {
	   //     hmap.put(arr[i], hmap.getOrDefault(arr[i], 0) + 1);
	   // }
	   int count = 0;
	   for(int elem : set) {
	       int p1 = elem;
	        if(k != 0 && set.contains(p1 + k)) {
	            count++;
	        }
	   }
      return count;
    }

	public static void main(String[] args) {
		//failed test case, hence use hashmap
		int[] nums = {3,1,4,1,5};
		System.out.println(findPairs(nums, 0));

	}
}
