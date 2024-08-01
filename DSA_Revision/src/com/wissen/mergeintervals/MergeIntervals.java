package com.wissen.mergeintervals;

import java.util.*;

public class MergeIntervals {

	//TC: O(N*logN) + O(N) one pass
	//SC: O(m*n)
	public static int[][] merge(int[][] arr) {
		//sort the 2d array
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				//if first val of arr are same then sort based on the second array
				if(a[0] == b[0]) {
					return a[1] - b[1];
				}
				return a[0] - b[0];
			}
		});
		
		int n = arr.length;
		List<int[]> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			int start = arr[i][0];
			int end = arr[i][1];
			//curr interval is first interval or non overlapping interval, add curr interval as new
			if(list.isEmpty() || start > list.get(list.size()-1)[1]) {
				int[] temp = {start, end};
				list.add(temp);
			}
			else {
				int firstEleOfBack =  list.get(list.size()-1)[0];
				int secondEleOfBack =  list.get(list.size()-1)[1];
				int lastPos = list.size()-1;
				//take max (current second & last element second) from the purpose of occupancy
				int[] temp = {firstEleOfBack, Math.max(end, secondEleOfBack)};
				//set current merged interval at the last position
				list.set(lastPos, temp);
			}
		}
		
		int[][] res = new int[list.size()][2];
		for(int i=0; i<res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] nums = {
				{1,3},
				{2,6},
				{8,9},
				{9,11},
				{8,10},
				{2,4},
				{15,18},
				{16,17}
		};
		
		int[][] merge = merge(nums);
		for(int[] temp: merge) {
			for(int val : temp) {
				System.out.print(val + " ");
			}
			System.out.println();
		}

	}

}
