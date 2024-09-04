package com.wissen.simulation;

public class Convert1DArrayInto2DArray {

	// TC: O(arr.len)
	// SC: O(m*n)
	public int[][] construct2DArray(int[] arr, int m, int n) {
		int[][] res = new int[m][n];
		int k = 0;
		int len = arr.length;
		// if total elements of arr equals to total elements of 2d array
		if ((m * n) == len) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (k < len) {
						res[i][j] = arr[k];
						k++;
					}
				}
			}
		} else {
			return new int[][] {};
		}

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
