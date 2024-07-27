package org.wissen.binarysearch;

public class SearchInRotatedSortedArray {

	// TC: O(logn)
	// SC: O(1)
	public int search(int[] nums, int target) {
		int ans = -1;
		int n = nums.length;
		int low = 0, high = n - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				ans = mid;
				break;
			} else if (nums[low] <= nums[mid]) { // sorted space
				if (nums[low] <= target && target <= nums[mid]) {
					high = mid;
				} else {
					low = mid + 1;
				}
			} else { // unsorted space
				if (nums[mid + 1] <= target && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
