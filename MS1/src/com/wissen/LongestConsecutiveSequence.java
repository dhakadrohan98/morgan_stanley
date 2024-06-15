package com.wissen;

import java.util.*;

public class LongestConsecutiveSequence {

	// TC: O(n)
	// SC: O(n)
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		Set<Integer> set = new HashSet<>();
		int longest = 0;

		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		for (int val : set) {
			if (!set.contains(val - 1)) {
				int tempVal = val;
				int count = 1;
				while (set.contains(tempVal + 1)) {
					count++;
					tempVal += 1;
				}
				longest = Math.max(longest, count);
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
