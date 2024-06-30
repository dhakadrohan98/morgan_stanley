package com.wissen.blind75;

public class FindMinimumInRotatedSortedArrayV_1 {
	//TC: O(logN)
	//SC: O(1)
	public int findMin(int[] nums) {
		int n = nums.length;
		int low = 0, high = n - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;

			// If the mid element is greater than the high element, the minimum is in the
			// right half
			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				// Otherwise, the minimum is in the left half (including mid)
				high = mid;
			}
		}

		// After the loop, low == high and points to the minimum element
		return nums[low];
	}
}
