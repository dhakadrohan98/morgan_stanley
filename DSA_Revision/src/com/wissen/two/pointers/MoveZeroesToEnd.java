package com.wissen.two.pointers;

public class MoveZeroesToEnd {

	public static void moveZeroes(int[] nums) {
		int n = nums.length;
		int left = 0, right = 0;

		// take two pointers initially at 0th index only
		while (right < n) {
			// Take the right pointer to non zero element
			if (nums[right] == 0) {
				right++;
			} else if (left != right) {
				swap(left, right, nums);
				left++;
				right++;
			}
			// if left & right pointer at the same index, then move ahead simply
			// avoiding swapping in this case
			else if (left == right) {
				left++;
				right++;
			}
		}

		// print the result array
		for (int temp : nums) {
			System.out.print(temp + " ");
		}
		System.out.println();
	}

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums0 = { 3, 5, 0, 0, 4 };
		int[] nums1 = { 0, 0, 0, 4 };
		int[] nums2 = { 0, 1, 0, 3, 12 }; // {1,0,0,3,12} => {}
		int[] nums3 = { 2, 1 };
		int[] nums4 = { 1, 0, 1 };
		int[] nums5 = { 0, 0, 1 };
		int[] nums6 = { 1, 0 };

		moveZeroes(nums0);
		moveZeroes(nums1);
		moveZeroes(nums2);
		moveZeroes(nums3);
		moveZeroes(nums4);
		moveZeroes(nums5);
		moveZeroes(nums6);
	}
}
