package com.wissen.graph;

public class NumberOfIslands {

	// TC: O(m*n)
	// SC: O(m*n)
	public int numIslands(char[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		boolean[][] visited = new boolean[row][col];
		int islands = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1' && visited[i][j] == false) {
					islands++;
					dfs(i, j, grid, visited);
				}
			}
		}
		return islands;
	}

	private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
		// base case
		if (isValid(i, j, grid) == false) {
			return;
		}

		if (grid[i][j] == '0' || visited[i][j] == true) {
			return;
		}
		// mark current grid as visited.
		visited[i][j] = true;
		// move into four directions horizontally & vertically
		dfs(i - 1, j, grid, visited); // up
		dfs(i, j + 1, grid, visited); // right
		dfs(i + 1, j, grid, visited); // down
		dfs(i, j - 1, grid, visited); // left
	}

	private boolean isValid(int i, int j, char[][] grid) {
		return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
