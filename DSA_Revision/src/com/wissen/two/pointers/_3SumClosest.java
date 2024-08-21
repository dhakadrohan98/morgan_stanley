package com.wissen.two.pointers;

import java.util.Arrays;

public class _3SumClosest {

	// TC: O(n^2) due to quick sort on primitive types + O(n^2)
	// SC: O(n) due to quick sort
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		int closer = Integer.MAX_VALUE;
		int i = 0;
		int ansSum = 0;

		while (i < n - 2) {
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				int absoluteDiff = Math.abs(sum - target);
				// calculation for closer difference
				if (absoluteDiff < closer) {
					closer = absoluteDiff;
					ansSum = sum;
				}

				if (sum == target) {
					return sum;
				} else if (sum < target) {
					j++;
				} else { // diff > target
					k--;
				}
			}
			// increment i pointer
			i++;
		}
		return ansSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
