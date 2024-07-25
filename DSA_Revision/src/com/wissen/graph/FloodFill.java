package com.wissen.graph;

public class FloodFill {

	//TC: O(V+E)
	//SC: O(E)
	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor = image[sr][sc];
		dfs(image, sr, sc, color, inicolor);
		return image;
	}

	private static void dfs(int[][] mat, int r, int c, int color, int inicolor) {
		// base case
		if (isValid(r, c, mat)) {
			return;
		}
		//if current grid is 0 or 2 then don't do anything return from here.
		if (mat[r][c] == color || mat[r][c] != inicolor) {
			return;
		}
         // color current grid
		    mat[r][c] = color;   

		// move into 4-direction
		dfs(mat, r - 1, c, color, inicolor); // up
		dfs(mat, r, c + 1, color, inicolor); // right
		dfs(mat, r + 1, c, color, inicolor); // down
		dfs(mat, r, c - 1, color, inicolor); // left
	}
	
	private static boolean isValid(int i, int j, int[][] mat) {
		return i < 0 || i >= mat.length || j < 0 || j >= mat[0].length;
	}

	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1, sc = 1, color = 2;
		int[][] floodFill = floodFill(image, sr, sc, color);

		for (int[] temp : floodFill) {
			for (int val : temp) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

}
