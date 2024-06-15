package com.wissen.hashtable;

import java.util.*;

public class ThreeSum {

	// TC: O(n*logn) + O(n^2)
	// SC: O(n) for merger sort
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> res = new HashSet<>();
		int n = nums.length;
		int j = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					res.add(new ArrayList(list));
					j++;
					k--;
				} else if (sum > 0) {
					k--;
				} else if (sum < 0) {
					j++;
				}
			}
		}
		return new ArrayList<>(res);
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> threeSum = threeSum(nums);
		System.out.println(threeSum);
	}
}
