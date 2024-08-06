package com.wissen.dp;

import java.util.*;
public class KinghtProbabilityInChess {
	
	//TC: O(N^2 * K)
    //SC: O(k) recursion stack space + memoization space (N^2 * K)
    private int[][] dir = {
                         {-2,-1}, {-2,1}, {-1, 2}, {1,2}, 
                         {2,-1}, {2,1}, {-1,-2}, {1,-2}
                        };
    
    public double knightProbability(int n, int k, int row, int column) {
        int steps = k;
        Map<String, Double> hmap = new HashMap<>();
        return find(n, steps, row, column, hmap);
    }
    
    private double find(int n, int steps, int r, int c, Map<String, Double> hmap) {
        
        String key = r +"_" + c + "_" + steps;
        //two base cases
        // If the knight moves off the board (isValid returns false), the probability is 0.
        
        if(isValid(r, c, n) == false) {
            return 0; //
        }
        // If no more moves are left (K == 0), the probability is 1 because the knight is still on the board.
        if(steps == 0) {
            return 1;
        }
        
        //memoization check
        if(hmap.containsKey(key)) {
            return hmap.get(key);
        }
        
        double probability = 0.0;
        //recursively check into eight directions by reducing steps by 1 & dividing by 8 at each step
        for(int i=0; i < dir.length; i++) {
            probability = probability + find(n, steps-1, r + dir[i][0], c + dir[i][1], hmap)/8.0;
        }
        //memoizing it
        hmap.put(key, probability);
        return probability;
    }
    
    private boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
