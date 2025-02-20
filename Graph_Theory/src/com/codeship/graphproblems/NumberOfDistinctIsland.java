package com.codeship.graphproblems;

import java.util.*;

//TC: O(n*m) + O(4*m*n) dfs traversal
//SC: O(n*m) visited + O(n*m) to store into set
public class NumberOfDistinctIsland {
	private static boolean isValid(int row, int col, int[][] mat) {
        return row >= 0 && row < mat.length && col >= 0 && col < mat[0].length;
    }
    
    private void dfs(int row, int col, boolean[][] vis, int[][] grid, 
    List<String> list, int row0, int col0) {
        vis[row][col] = true;
        //add curret coordinates after sbtracting it from base(r0, c0) into list
        list.add((row - row0) +","+ (col - col0));
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = {-1, 0, +1, 0};
        int[] dy = {0, -1, 0, +1};
        //apply dfs into four direction
        for(int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if(isValid(nrow, ncol, grid) && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, list, row0, col0);
            }
        }
        
    }   
    
    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        //Set will contain unique shapes only
        Set<List<String>> set = new HashSet<>();
        //O(m*n) + O(4*m*n)
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    //make a new list of string to store shapes
                    List<String> list = new ArrayList<>();
                    dfs(i, j, vis, grid, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
