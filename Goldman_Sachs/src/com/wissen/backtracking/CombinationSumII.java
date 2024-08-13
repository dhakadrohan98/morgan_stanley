package com.wissen.backtracking;

import java.util.*;
public class CombinationSumII {

	// TC: O(2^n * k) k , we also add the ds to our ans when we reach the base case
	// that will take “k”//average time to add curr valid combination to the result
	// List.
	// SC: O(k*x) if we have x combinations then space will be x*k where k is the
	// average length of the combination.
	public List<List<Integer>> combinationSum2(int[] arr, int target) {
		Arrays.sort(arr);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		dfs(0, target, arr, list, res);
		return res;
	}

	private void dfs(int start, int target, int[] arr, List<Integer> ans, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<>(ans));
			return;
		}
		// check for start indx till last indx & skip duplicates elements. if at any
		// point arr[indx] > target then break the loop because further combination is
		// not possible due to sorted elements (in increasing order)
		for (int i = start; i < arr.length; i++) {
			if (i > start && arr[i] == arr[i - 1])
				continue; // skip duplicates
			if (arr[i] > target)
				break; // no need to continue if the current number is greater than the target
			ans.add(arr[i]);
			dfs(i + 1, target - arr[i], arr, ans, res);
			ans.remove(ans.size() - 1); // backtrack
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
