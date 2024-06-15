package com.wissen.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class DuplicateNumbersSameNumberOfTimes {
	//TC: O(n)
	//SC: O(n)
	public static boolean isDuplicateElementsSameNoOfTimes(int[] nums) {
		Map<Integer, Integer> hmap = new HashMap<>();
		Set<Integer> set= new HashSet();
		
		for(int i=0; i<nums.length; i++) {
			hmap.put(nums[i], hmap.getOrDefault(nums[i], 0)+1);
		}
		
		for(Entry<Integer, Integer> map : hmap.entrySet()) {
			int key = map.getKey();
			int val = map.getValue();
			if(set.contains(val)) {
				return false;
			}
			else {
				set.add(val);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,2,3,4,3,4,4,5,5,10,2,3};
		int[] nums2 = {1,2,3,4,2,3,4,3,4,4};
		System.out.println(isDuplicateElementsSameNoOfTimes(nums2));

	}
}
