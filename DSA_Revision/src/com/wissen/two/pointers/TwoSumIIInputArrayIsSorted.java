package com.wissen.two.pointers;

public class TwoSumIIInputArrayIsSorted {

	//TC: O(n)
	//SC: O(1)
	public int[] twoSum(int[] nums, int target) {
		int n = nums.length;
		int i = 0, j = n - 1;
		int[] res = new int[2];

		while (i < j) {
			if (nums[i] + nums[j] > target) {
				j--;
			} else if (nums[i] + nums[j] < target) {
				i++;
			} else { // nums[i] == nums[j]
				res[0] = i + 1;
				res[1] = j + 1;
				return res;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
