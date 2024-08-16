package com.wissen.greedy;

public class CountNumberofTeams_Greedy_Approach {

	// TC: O(n^2)
	// SC: O(1)
	public static int numTeams(int[] nums) {
		int n = nums.length;
		int ans = 0;

		for (int j = 1; j < n - 1; j++) {
			int countLeftSmaller = 0;
			int countRightGreater = 0;
			int countLeftGreater = 0;
			int countRightSmaller = 0;

			// strictly increasing sequence case
			for (int i = 0; i < j; i++) {
				if (nums[i] < nums[j]) {
					countLeftSmaller++;
				} else if (nums[i] > nums[j]) {
					countLeftGreater++;
				}
			}

			// strictly decreasing sequence case
			for (int i = j + 1; i < n; i++) {
				if (nums[j] > nums[i]) {
					countRightSmaller++;
				} else if (nums[j] < nums[i]) {
					countRightGreater++;
				}
			}

			ans += (countLeftSmaller * countRightGreater) + (countLeftGreater * countRightSmaller);
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 7, 4, 5 };
		int[] nums1 = { 2, 5, 3, 4, 1 };
		System.out.println(numTeams(nums1));

	}

}
