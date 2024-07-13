package com.wissen.two.pointers;

import java.util.*;

public class _3SumClosest {
	//TC: O(n^2)
    //SC: O(n^2)
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			int k = n - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					set.add(list);
					j++;
					k--;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return new ArrayList<>(set);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
