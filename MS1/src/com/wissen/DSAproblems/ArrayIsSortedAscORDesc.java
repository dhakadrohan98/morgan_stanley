package com.wissen.DSAproblems;

public class ArrayIsSortedAscORDesc {
	
	//TC: O(n)
	//SC: O(1)
	public static boolean isArraySorted(int[] nums) {
		int n = nums.length;

		// edge case
		if (n <= 1)
			return true; // An array with 0 or 1 element is always sorted

		int i = 0;
		// if numbers are duplicate then take i pointer to the index where element at
		// index & index+1 are different
		while (i + 1 < n && nums[i] == nums[i + 1]) {
			i++;
		}
		int first = nums[i];
		int second = nums[i + 1];
		boolean isAscending = false;

		if (first < second) {
			isAscending = true;
		}
		if (isAscending) {
			int j = i + 1;
			while (j < n) {
				if (nums[j] < nums[i]) {
					return false;
				}
				i++;
				j++;
			}
		} else {
			int j = i + 1;
			while (j < n) {
				if (nums[j] > nums[i]) {
					return false;
				}
				i++;
				j++;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 1, 2, 3, 3, 4, 4, 4, 5 };
		int[] nums2 = { 10, 10, 10, 9, 8, 8, 9, 6, 4, 4, 1 };

		System.out.println(isArraySorted(nums1));
		System.out.println(isArraySorted(nums2));

	}

}
