package com.wissen.matrix;

public class SpiralMatrixIII {
//	TC: O(max(rows, cols)^2) //in worst case we have to traverse the max(rows, cols)^2 grid anticlockwise reverse direction.
//	SC: O(rows*cols) //storing ans

	public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
		int[][] directions = { 
				{ 0, 1 }, // east
				{ 1, 0 }, // south
				{ 0, -1 }, // west
				{ -1, 0 } // north 
				}; 

		int[][] result = new int[rows * cols][2];
		int step = 0;
		int dir = 0;

		result[0] = new int[] { rStart, cStart };
		int count = 1;

		while (count < rows * cols) {
			// When we move east & west, we need to increase our step by 1.
			if (dir == 0 || dir == 2) {
				step++;
			}

			for (int i = 0; i < step; i++) {
				// Jis direction (dir) mein bhi jaa rhe hn wahan kitna move krna hn
				rStart = rStart + directions[dir][0];
				cStart = cStart + directions[dir][1];

				if (isValid(rStart, cStart, rows, cols) == true) {
					result[count] = new int[] { rStart, cStart };
				}
			}

			dir = (dir + 1) % 4;// turn to the next direction
		}
		
		return result;
	}

	private boolean isValid(int i, int j, int m, int n) {
		return i >= 0 && i < m && j >= 0 && j < n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
