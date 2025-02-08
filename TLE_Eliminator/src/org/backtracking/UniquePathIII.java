package org.backtracking;

public class UniquePathIII {
	
	int[] dx = {0, 0, 1, -1};
	int[] dy = {1, -1, 0, 0};
	private int helper(int r, int c, int count, int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		//base case
		//we went out of grid or we found obstacle
		if(r < 0 || r >=n || c < 0 || c >= m || grid[r][c] == -1) {
			return 0;
		}
		//if we have reached the ending cell & covered all empty squares
		if(grid[r][c] == 2) {
			//we have reduced the count when we have started from the starting square, that's why count will 
			//checked for -1.
			if(count == -1) return 1;
		}
		//store current grid value into temp & reassign them when we backtrack from the bottom of the tree
		int temp = grid[r][c];
		//mark current cell as visited by making a wall
		grid[r][c] = -1;
		int ans = 0;
		//go into four directions
		for(int i=0; i<4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			ans = ans + helper(nr, nc, count -1, grid);
		}
		//while backtrack, assign curr cell with its original value to explore the another unique path
		grid[r][c] = temp;h
		return ans;
	}
	
	public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //helps me to store the number of empty squares;
        int count = 0;
        int start_r = 0;
        int start_c = 0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		//starting cell is found
        		if(grid[i][j] == 1) {
        			//starting row & colunm
        			start_r = i;
        			start_c = j;
        		}
        		//count the no. of empty squares
        		if(grid[i][j] == 0) {
        			count++;
        		}
        	}
        }
        int ans = helper(start_r, start_c, count, grid);
        return ans;
        
    }

}
