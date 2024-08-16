package com.wissen.greedy;

public class CountNumberofTeams_Greedy_Approach {

	// TC: O(2n^2)
	// SC: O(1)
	public static int numTeams(int[] nums) {
		int n = nums.length;
		int teams = 0;

		for (int j = 1; j < n - 1; j++) {
			int smallerLeft = 0;
			int smallerRight = 0;
			int largerLeft = 0;
			int largerRight = 0;

			// Store smaller & larger elements count for left portion w.r.t. i
			for (int i = 0; i < j; i++) {
				if (nums[i] < nums[j]) {
					smallerLeft++;
				} else if (nums[i] > nums[j]) {
					largerLeft++;
				}
			}

			// Store smaller & larger elements count for right portion w.r.t. i
			for (int k = j + 1; k < n; k++) {
				if (nums[j] < nums[k]) {
					largerRight++;
				} else if (nums[j] > nums[k]) {
					smallerRight++;
				}
			}

			teams += (smallerLeft * largerRight) + (largerLeft * smallerRight);
		}

		return teams;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 7, 4, 5 };
		int[] nums1 = { 2, 5, 3, 4, 1 };
		System.out.println(numTeams(nums1));

	}

}
