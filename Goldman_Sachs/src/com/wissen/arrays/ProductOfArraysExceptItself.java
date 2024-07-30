package com.wissen.arrays;

public class ProductOfArraysExceptItself {

	// TC: O(3*nN)
	// SC: O(3*N)
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		
		//edge case
		if(n == 0) {
			return new int[0];
		}
		int[] prefix = new int[n];
		int[] suffix = new int[n];
		int[] res = new int[n];
		prefix[0] = 1;
		suffix[n - 1] = 1;
		// prefix product calculation
		for (int i = 1; i < n; i++) {
			prefix[i] = nums[i - 1] * prefix[i - 1];
		}
		// suffix product calculation
		for (int j = n - 2; j >= 0; j--) {
			suffix[j] = nums[j + 1] * suffix[j + 1];
		}

		// final product
		for (int i = 0; i < n; i++) {
			res[i] = prefix[i] * suffix[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4}; //[24,12,8,6]
		int[] nums2 = {-1,1,0,-3,3}; // [0,0,9,0,0]
	}

}
