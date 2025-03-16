package com.codeship.graphproblems;

import java.util.*;

public class ShortestDistanceInBinaryMaze {
	class Pair {
        int distance;
        int row;
        int col;
        
        public Pair(int dist, int row, int col) {
            this.distance =  dist;
            this.row = row;
            this.col = col;
        }
    }

    public int shortestPath(int[][] grid, int[] source, int[] destination) {
        //if source & destination cells both are same
        if(source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }
        
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        //dist array of same size(n*m) of given matrix
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = (int)1e9;
            }
        }
        //mark curr source node with 0 distance
        dist[source[0]][source[1]] = 0;
        q.offer(new Pair(0, source[0], source[1]));
        //coordinates to travel into four direction
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        //n * m
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int dis = pair.distance;
            int row = pair.row;
            int col = pair.col;
            //4 direction
            for(int i = 0; i < 4; i++) {
                int newr = row + dx[i];
                int newc = col + dy[i];
                
                if(newr >= 0 && newr < n && newc >= 0 &&  newc < m 
                && grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = dis + 1;
                    if(newr == destination[0] && newc == destination[1]) {
                        return dis + 1;
                    }
                    q.offer(new Pair(1 + dis, newr, newc));
                }
            }
        }
        return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
