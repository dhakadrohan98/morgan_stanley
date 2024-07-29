package com.wissen.arrays;

public class ProductOfArraysExceptItself {

	// TC: O(3*nN)
	// SC: O(3*N)
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
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
		
	}

}
