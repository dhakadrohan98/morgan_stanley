package com.wissen.graph;

public class NoOfIslandsSpaceOptimal {
	
	 //TC: O(m*n)
    //SC: O(m*n) stack space (if all cells are land)
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    dfs(i, j, grid);
                }
            }
        }
        return islands;
    }
    
    private void dfs(int i, int j, char[][] grid) {
        //base case if ran out of indexes(from any one side) or encounterd water at curr grid
        if(isValid(i, j, grid) == false || grid[i][j] =='0') {
            return;
        }
        
        //mark curr grid(piece of land) as water
        grid[i][j] = '0';
         //move vertically (up & down)
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        //move horizontally (left & right)
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
      }
    
    private boolean isValid(int i, int j, char[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
