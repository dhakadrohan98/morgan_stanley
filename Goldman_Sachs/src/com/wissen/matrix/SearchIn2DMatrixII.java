package com.wissen.matrix;

public class SearchIn2DMatrixII {
//	TC: O(n+m)
//	SC: O(1)
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int row = 0;
		int col = n - 1;
		while (row < m && col >= 0) {
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				row += 1;
			} else {
				col -= 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
