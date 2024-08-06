package com.wissen.matrix;

public class GameOfLife {

	// Function to check validity of neighbor
	public boolean isValidNeighbor(int x, int y, int[][] board) {
		return (x >= 0 && x < board.length && y >= 0 && y < board[0].length);
	}

	public void gameOfLife(int[][] board) {
		int[] dx = { 0, 0, 1, 1, 1, -1, -1, -1 }; // 8 coordinates for neighbors
		int[] dy = { 1, -1, 1, -1, 0, 0, 1, -1 };
		
		//line no. 33: live cell to dead cell (0 -> -1)
		//line no. 37: dead cell to live cell (0 -> 2)
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				int countLiveNeighbors = 0;

				for (int i = 0; i < 8; i++) {
					int currX = row + dx[i];
					int currY = col + dy[i];
					//live cell(unchanged) && became dead cell(from live previously) 
					//are counted as live neighbors
					if (isValidNeighbor(currX, currY, board) && Math.abs(board[currX][currY]) == 1)
						countLiveNeighbors++;
				}
//				1. Any live cell with fewer than two live neighbors dies as if caused by under-population.
//				2. Any live cell with two or three live neighbors lives on to the next generation.
//				3. Any live cell with more than three live neighbors dies, as if by over-population.
				//line no. 33: live cell to dead cell (0 -> -1)
				if (board[row][col] == 1 && (countLiveNeighbors < 2 || countLiveNeighbors > 3))
					board[row][col] = -1;
//				4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
				//line no. 37: dead cell to live cell (0 -> 2)
				if (board[row][col] == 0 && countLiveNeighbors == 3)
					board[row][col] = 2;
			}
		}

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] >= 1)
					board[row][col] = 1;
				else
					board[row][col] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
