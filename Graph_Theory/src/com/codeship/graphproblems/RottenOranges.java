package com.codeship.graphproblems;
import java.util.*;

public class RottenOranges {
	//TC: O(m*n)
	//SC: O(m*n)
	class Pair {
        int row;
        int col;
        int t;
        Pair(int row, int col, int t) {
            this.row = row;
            this.col = col;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //pair -> {{r, c}, t}
        Queue<Pair> queue = new LinkedList<>();
        //visited array to store rotten oranges only
        int[][] visited = new int[n][m];
        int countFresh = 0;
        //there can be more than one rotten oranges intially, identify them & put into
        //the queue and make them rotten in visited array
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    //initially time will be 0 sec
                    queue.offer(new Pair(i, j, 0));
                    //mart this orange as rotten in visited array
                    visited[i][j] = 2;
                }

                if(grid[i][j] == 1) countFresh++;
            }
        }

        int time = 0;
        //traverse into four direction neighbours(bfs to move with same pace)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 0;

        while(!queue.isEmpty()) {
            //remove first element from the queue
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            int t = p.t;
            //take maximum of current time & time at which curr row & col are pushed into queue to make oranges rotten
            time = Math.max(time, t);
            //explore four directions
            for(int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];
                //if curr grid pos is valid and oragnges are fresh and never rotten(never visited)
                if(isValid(nrow, ncol, grid, visited)) {
                    //add current row & col into queue
                    queue.add(new Pair(nrow, ncol, t+1));
                    //make curr orange rotten
                    visited[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
    // if all oranges are not rotten
        if(cnt != countFresh) return -1;
        return time;
    }

    private static boolean isValid(int row, int col, int[][] grid, int[][] visited) {
        //curr grid pos is valid
        if(row >= 0 && row < grid.length && col >=0 && col < grid[0].length) {
            //oranges are fresh & never rotten(never visited)
            if(grid[row][col] == 1 && visited[row][col] == 0) {
                return true;
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
