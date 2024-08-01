package com.wissen.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2DArray {

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
		
		Arrays.sort(nums, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				//if first value of array are equal, then sort based on second value of array
				if(a[0] == b[0]) {
					return a[1] - b[1];
				}
				return a[0] - b[0];
			}
		});
		
		for(int[] arr:nums) {
			for(int val: arr) {
				System.out.print(val + ", ");
			}
			System.out.println();
		}

	}

}
