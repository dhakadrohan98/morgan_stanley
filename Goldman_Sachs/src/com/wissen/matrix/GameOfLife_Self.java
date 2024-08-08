package com.wissen.matrix;

import java.util.Arrays;

public class GameOfLife_Self {

	public static void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// count live neighbors
				int liveNeighbors = 0;
				for (int k = 0; k < 8; k++) {
					int newX = i + dx[k];
					int newY = j + dy[k];
					if (isValid(newX, newY, m, n) == true && Math.abs(board[newX][newY]) == 1) {
						liveNeighbors++;
					}
				}

				if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
					board[i][j] = -1; // change 1(live cell) to -1(dead cell)
				}

				if (board[i][j] == 0 && liveNeighbors == 3) {
					board[i][j] = 2;// change 0(dead cell) to 2(live cell)
				}
			}
		}

		// change the grid values from previous state(preserved for next) to next state
		// values
		// according to live cell(1) & dead cell(0)
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] >= 1)
					board[i][j] = 1;
				else
					board[i][j] = 0;
			}
		}
	}

	private static boolean isValid(int i, int j, int m, int n) {
		return i >= 0 && i < m && j >= 0 && j < n;
	}

	public static void main(String[] args) {
		int[][] nums = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		gameOfLife(nums);
		for(int[] temp:  nums) {
			System.out.println(Arrays.toString(temp));
		}
	}

}
