package com.wissen.variablesize.sliding.window;

public class MinimumSizeSubarraySum {

	// TC O(n)
	// SC: O(n)
	public static int minSubArrayLen(int target, int[] nums) {
		int n = nums.length;
		int i = 0, j = 0, min = Integer.MAX_VALUE;
		int sum = 0;

		while (j < n) {
			sum += nums[j];
			// if sum is less than target then incr. j pointer
			// to reach till given cond. (sum >= target)
			if (sum < target) {
				j++;
			} else if (sum == target) {
				// calculate for ans cond is satisfied (sum >= target)
				min = Math.min(min, j - i + 1);
				// remove calculations for i
				sum -= nums[i];
				// slide the window
				i++;
				j++;
			} else {
				// sum > target is valid, hence calculate for ans AND
				// remove calculations for i unti sum > target
				while (sum > target) {
					min = Math.min(min, j - i + 1);
					sum -= nums[i];
					// increment the i pointer
					i++;
				}
				// check for ans again after shrinking the window
				if (sum == target) {
					// calculate for ans cond is satisfied (sum >= target)
					min = Math.min(min, j - i + 1);
					// remove calculations for i
					sum -= nums[i];
					// slide the window
					i++;
				}
				// incre rightmost pointer
				j++;
			}
		}
		if (min == Integer.MAX_VALUE) {
			min = 0;
		}
		return min;
	}

	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		int target = 7;
		System.out.println(minSubArrayLen(target, nums));

	}

}
