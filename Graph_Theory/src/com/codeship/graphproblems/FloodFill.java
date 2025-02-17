package com.codeship.graphproblems;

public class FloodFill {
	
	static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        dfs(image, sr, sc, color, visited);
        return image;
    }

    private static void dfs(int[][] image, int sr, int sc, int color, 
    boolean[][] visited) {
        //change the color of curr cell
        int original_color = image[sr][sc];
        image[sr][sc] = color;
        visited[sr][sc] = true;
        //explore the four direction
        for(int i = 0; i < 4; i++) {
            int new_sr = sr + dx[i];
            int new_sc = sc + dy[i];
            if(isValid(new_sr, new_sc, image) && !visited[new_sr][new_sc] && 
            image[new_sr][new_sc] == original_color) {
                dfs(image, new_sr, new_sc, color, visited);
            }
        } 
    }

    private static boolean isValid(int i, int j, int[][] image) {
        return i >= 0 && i < image.length && j >= 0 && j < image[0].length;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
