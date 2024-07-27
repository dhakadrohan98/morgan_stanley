package org.wissen.binarysearch;

public class FloorInSortedArray {
	// TC: O(logn)
	// SC: O(1)
	public static long findFloor(long arr[], int n, long target) {
		long ans = -1;
		int low = 0, high = n - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (target >= arr[mid]) {
				ans = arr[mid];
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		long[] arr = { 1, 2, 8, 10, 11, 12, 19 };
		System.out.println(findFloor(arr, arr.length, 9));

	}

}
