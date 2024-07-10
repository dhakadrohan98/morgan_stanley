package com.wissen.graph;

public class NoOfIslands {
	//TC: O(n^2)
    //SC: O(n^2)
	public int numIslands(char[][] grid) {
        //edge case
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }
    
    private void dfs(int i, int j, char[][] grid) {
        //base cases
        //out of boundary
        if(isValid(i, j, grid) == false) {
           return; 
        }
        //if curr grid value is water
        if(grid[i][j] == '0') {
            return;
        }
        
        //convert land into water, visited array will not be required
        if(grid[i][j] == '1') {
            grid[i][j] = '0';
        }
        //travel into foud directions
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
    }
    
    public boolean isValid(int i,int j, char[][] grid) {
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
