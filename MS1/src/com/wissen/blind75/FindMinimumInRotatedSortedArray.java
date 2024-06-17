package com.wissen.blind75;

public class FindMinimumInRotatedSortedArray {

	// TC: O(logN)
	// SC: O(1)
	public int findMin(int[] nums) {
		int n = nums.length;
		int low = 0, high = n - 1;
		int ans = Integer.MAX_VALUE;

		while (low <= high) {
			int mid = (low + high) / 2;
			// search space is already sorted then always nums[low] will be smaller in that
			// search space.
			if (nums[low] <= nums[high]) {
				ans = Math.min(ans, nums[low]);
				break;
			}

			// if left half is sorted
			if (nums[low] <= nums[mid]) {
				ans = Math.min(ans, nums[low]);
				// eliminate the left half
				low = mid + 1;
			}
			// right half is sorted
			else {
				ans = Math.min(ans, nums[mid]);
				// eliminate the right half
				high = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// passed for 84/150 test cases
	public int findMinFailed(int[] arr) {
		int n = arr.length;

		// edge case
		if (n == 1) {
			return arr[0];
		}
		if (n == 2) {
			return Math.min(arr[0], arr[1]);
		}

		int low = 0, high = n - 1;
		int min = Integer.MAX_VALUE;

		while (low < high) {
			int mid = (low + high) / 2;
			min = Math.min(min, arr[mid]);

			if (arr[low] <= arr[mid]) {
				if (arr[mid] > arr[mid + 1]) {
					low = mid + 1;
				} else {
					high = mid;
				}
			} else if (arr[low] > arr[mid]) {
				if (arr[mid] <= arr[high]) {
					high = mid;
				} else {
					low = mid + 1;
				}
			}
		}
		return min;
	}

	// naive approach
	// TC: O(n)
	// SC: O(1)
	public int findMinLinearApproach(int[] arr) {
		int min = Integer.MAX_VALUE;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, arr[i]);
		}
		return min;
	}

}
