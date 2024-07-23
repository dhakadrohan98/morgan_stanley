package com.wissen.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumEqualsK {
	//TC: O(n)
	//SC: O(n)
	public static int lenOfLongSubarr(int[] nums, int n, int k) {
		int longest = 0;
		Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		int prefixSum = 0;
		for (int i = 0; i < n; i++) {
			prefixSum += nums[i];
			if (prefixSum == k) {
				longest = i + 1;
			} else if (hmap.containsKey(prefixSum - k)) {
				int j = hmap.get(prefixSum - k);
				longest = Math.max(longest, i - j);
			}
			if (!hmap.containsKey(prefixSum)) {
				hmap.put(prefixSum, i);
			}
		}
		System.out.println(hmap);
		return longest;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 5, 2, 7, 1, 9 };
		int k = 15;
		System.out.println(lenOfLongSubarr(nums, nums.length, k));

	}

}
