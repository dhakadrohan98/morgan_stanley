package org.wissen.DP;

import java.util.*;

public class GenerateAllSubsequencesOfArray {

	static List<Integer> list = null;

	public static List<List<Integer>> generateAll(int[] nums) {
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		list = new ArrayList<>();
		helper(nums, res, list, n - 1);
		System.out.println(res.size());
		return res;
	}

	private static void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int indx) {
		// base case
		if (indx == -1) {
			res.add(new ArrayList<>(list));
			list = new ArrayList<>();
			return;
		}

		// pick
		list.add(nums[indx]); //pick the current element & add it into list
		helper(nums, res, list, indx - 1);

		// not pick
		list.remove(list.size() - 1); // Remove the last element added
		helper(nums, res, list, indx - 1);

	}

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int[] nums1 = {1,2,3};
		System.out.println(generateAll(nums));
	}
}
