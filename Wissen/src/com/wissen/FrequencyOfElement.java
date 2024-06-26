package com.wissen;

import java.util.*;
public class FrequencyOfElement {

	//TC: O(n)
	//SC: O(n)
	public static int countFrequency(int[] nums) {
		Map<Integer,Integer> hmap = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			hmap.put(nums[i], hmap.getOrDefault(nums[i],0) + 1);
		}
		
		int maxFreq = 0;
		for(int key: hmap.keySet()) {
			int val = hmap.get(key);
			maxFreq = Math.max(val, maxFreq);
		}
		
		return maxFreq;
	}
	public static void main(String[] args) {
		int[] arr = {10, 20, 20, 10, 10, 20, 5, 20};
		int countFrequency = countFrequency(arr);
		System.out.println(countFrequency);

	}

}
