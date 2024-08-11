package com.wissen.graph;

public class MinimumNumberOfDaysToDisconnectLand {
	public int minDays(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		// initially count no. of islands
		int islands = numIslands(grid);
		// Already Either we have disconnected island or we don't have any island
		if (islands > 1 || islands == 0) {
			return 0;
		} else { // we have only one islands
					// check if we can disconnect the grid in one day
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 1) {
						grid[i][j] = 0; // convert into water & count no. of islands
						islands = numIslands(grid);
						grid[i][j] = 1; // make it land again & now go to try next cell
						if (islands > 1 || islands == 0) {
							return 1;
						}
					}
				}
			}
		}
		return 2;
	}

	//count no. of islands
	public int numIslands(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int islands = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					islands++;
					dfs(i, j, grid, visited);
				}
			}
		}
		return islands;
	}

	private void dfs(int i, int j, int[][] grid, boolean[][] visited) {
		if (!isValid(i, j, grid) || grid[i][j] == 0 || visited[i][j]) {
			return;
		}

		visited[i][j] = true;
		dfs(i - 1, j, grid, visited);
		dfs(i + 1, j, grid, visited);
		dfs(i, j - 1, grid, visited);
		dfs(i, j + 1, grid, visited);
	}

	private boolean isValid(int i, int j, int[][] grid) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
