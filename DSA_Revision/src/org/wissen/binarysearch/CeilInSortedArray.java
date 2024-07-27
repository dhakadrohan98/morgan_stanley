package org.wissen.binarysearch;

public class CeilInSortedArray {
	// TC: O(logn)
	// SC: O(1)
	public static int getAndCeil(int[] arr, int n, int target) {
		int ans = -1;
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] >= target) {
				ans = arr[mid];
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 7, 8, 8, 10 };
		System.out.println(getAndCeil(nums, nums.length, 5));

	}

}
