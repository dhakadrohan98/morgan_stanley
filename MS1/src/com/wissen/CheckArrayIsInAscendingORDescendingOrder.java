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
		
		while (nums[left] == nums[right]) {
			right++;
		}

		if (nums[left] < nums[right]) {
			isAscending = true;
		} else {
			isAscending = false;
		}
		
		//ascending order logic
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
		System.out.println(isAscDes(nums));
		System.out.println(isAscDes(nums1));

	}

}
