package com.wissen;

public class CheckArrayIsInAscendingORDescendingOrder {
	//TC: O(n)
	//SC: O(1)
	public static boolean isAscDes(int[] nums) {
		int n = nums.length;
		int left = 0, right = 0;
		boolean isAscending = false;
		//edge case
		if(n <= 1) {
			return true;
		}
		//increment right until elements at indexes left & right will be different
		while (nums[left] == nums[right]) {
			right++;
		}
		//check whether array's initial order is ascending or descending
		if (nums[left] < nums[right]) {
			isAscending = true;
		} else {
			isAscending = false;
		}
		
		//logic one pass for loop	
		for(int i=1; i<n; i++) {
			if(isAscending && nums[i-1] > nums[i]) {
				return false;
			}
			if(!isAscending && nums[i-1] < nums[i]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 4, 3};
		int[] nums1 = {6, 5, 4, 3};
		int[] nums2 = {1,1,1,3,3,5,7,8,10};
		System.out.println(isAscDes(nums));
		System.out.println(isAscDes(nums1));
		System.out.println(isAscDes(nums2));

	}

}
