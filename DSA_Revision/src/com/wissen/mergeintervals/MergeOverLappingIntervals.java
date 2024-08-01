package com.wissen.mergeintervals;

import java.util.*;

public class MergeOverLappingIntervals {

	// Optimal approach
	// TC: O(n^2) sort the 2d array + O(n)
	// SC: O(n) storing ans
	public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
		int n = arr.length; // size of the array
		// sort the given intervals:
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			// if the current interval does not
			// lie in the last interval:
			// ans.get(ans.size() - 1) -> last element of the array
			if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
				ans.add(Arrays.asList(arr[i][0], arr[i][1]));
			}
			// if the current interval
			// lies in the last interval:
			else {
				int maxi = Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]);
				ans.get(ans.size() - 1).set(1, maxi);
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int[][] nums = { { 1, 3 }, { 2, 6 }, { 8, 9 }, { 9, 11 }, { 8, 10 }, { 2, 4 }, { 15, 18 }, { 16, 17 } };
		List<List<Integer>> mergeOverlappingIntervals = mergeOverlappingIntervals(nums);
		System.out.println(mergeOverlappingIntervals);

	}

	// Brute force approach
	public static List<List<Integer>> mergeOverlappingIntervalsBruteForceApproach(int[][] arr) {
		int n = arr.length; // size of the array
		// sort the given intervals:
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) { // select an interval:
			int start = arr[i][0];
			int end = arr[i][1];

			// Skip all the merged intervals:
			if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
				continue;
			}

			// check the rest of the intervals:
			for (int j = i + 1; j < n; j++) {
				if (arr[j][0] <= end) {
					end = Math.max(end, arr[j][1]);
				} else {
					break;
				}
			}
			ans.add(Arrays.asList(start, end));
		}
		return ans;
	}

}
