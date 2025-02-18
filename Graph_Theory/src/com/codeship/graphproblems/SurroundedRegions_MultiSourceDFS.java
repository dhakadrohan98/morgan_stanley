package com.codeship.graphproblems;

//TC: O(m) -> O(n*m) first & last row + O(n) -> O(n*m) first & last col 
//+ O(n*m) last nested for loop
//SC: O(n*m) visited + O(max(n,m))


public class SurroundedRegions_MultiSourceDFS {
	
	private static boolean isValid(int row, int col, char[][] mat) {
        return row >= 0 && row < mat.length && col >= 0 && col < mat[0].length;
    }
    
    private static void dfs(int row, int col, boolean[][] vis, char[][] mat,
    int[] delrow, int[] delcol) {
        //mark curr grid as visited
        vis[row][col] = true;
        int n = mat.length;
        int m = mat[0].length;
        
        //check for top, right, bottom & left directions 
        for(int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(isValid(nrow, ncol, mat) && !vis[nrow][ncol] && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, mat, delrow, delcol);
            }
        }
    } 
    
    static char[][] fill(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        boolean[][] vis = new boolean[n][m];
        //traverse first row & last row
        for(int j = 0; j < m; j++) {
            
            //first row -> 0
            if(!vis[0][j] && mat[0][j] == 'O') {
                 dfs(0, j, vis, mat, delRow, delCol);
            }
            
            //last row -> n-1
            if(!vis[n-1][j] && mat[n-1][j] == 'O') {
                dfs(n-1, j, vis, mat, delRow, delCol);
            }
        }
        
        //traverse first col & last col
        for(int i = 0; i < n; i++) {
            
            //first col -> 0
            if(!vis[i][0] && mat[i][0] == 'O') {
                 dfs(i, 0, vis, mat, delRow, delCol);
            }
            
            //last col -> m-1
            if(!vis[i][m-1] && mat[i][m-1] == 'O') {
                dfs(i, m-1, vis, mat, delRow, delCol);
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }
        
        return mat;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
