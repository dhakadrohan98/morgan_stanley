package com.wissen.graph;

/**
 * This question can be solved using DFS & Union by find & rank, Disjoint sets 
 * 
 * */


public class CountSubIslands_DFS {
	
	//TC: O(m*n)
	//SC: O(m*n) longest island
	public int countSubIslands(int[][] grid1, int[][] grid2) {
        //through dfs
        int m = grid1.length;
        int n = grid1[0].length;
        int subIslands = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                //if current cell is land in grid 2, then call checkSubIslands method, which will perform dfs on current grid cell & simultaneously check same island in grid1 If it is found the increment the subIslands value by 1, Otherwise move ahead to next cell in grid2
                if(grid2[i][j] == 1 && checkSubIslands(grid1, grid2, i, j)) { //Found an island
                    subIslands++;              
                }
            }
        }
        return subIslands;
    }
    
    private boolean checkSubIslands(int[][] grid1, int[][] grid2, int i, int j) {
        //base cases to identify island 
        //if i or j or both gone out of grid, it means we have found one subIsland return true;
        if(i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length) {
            return true;
        }
        
        if(grid2[i][j] != 1) { //we need only land from grid2 then only perform dfs further, otherwise till i^th & j^th index island is found, return true from here
            return true;
        }
        
        if(grid1[i][j] == 0) { //if at current cell in grid1, there is water it can not be part of required island, return false.
            return false;
        }
        
        grid2[i][j] = -1; //mark visited that island in grid2
        
        //explore in all four directions from current cell of grid2 & grid1 simultaneously
        boolean up = checkSubIslands(grid1, grid2, i-1, j);
        boolean down = checkSubIslands(grid1, grid2, i+1, j);
        boolean left = checkSubIslands(grid1, grid2, i, j-1);
        boolean right = checkSubIslands(grid1, grid2, i, j+1);
        
        return (up && down && left && right);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
