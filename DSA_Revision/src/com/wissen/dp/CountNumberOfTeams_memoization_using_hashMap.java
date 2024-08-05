package com.wissen.dp;

import java.util.*;

public class CountNumberOfTeams_memoization_using_hashMap {

	//Using Hashmap to memoize it
	public static int numTeams(int[] rating) {
		Map<String, Integer> hmap = new HashMap<>();
		return countTeams(rating, 0, -1, -1, -1, hmap);
	}

	private static int countTeams(int[] rating, int currentIndex, int first, int second, int third,
			Map<String, Integer> hmap) {

		String key = currentIndex + "_" + first + "_" + second + "_" + third;
		// base case
		if (currentIndex == rating.length) {
			if (first != -1 && second != -1 && third != -1) {
				if ((rating[first] < rating[second] && rating[second] < rating[third])
						|| (rating[first] > rating[second] && rating[second] > rating[third])) {
					return 1;
				}
			}
			return 0;
		}

		// memoization check
		if (hmap.containsKey(key)) {
			return hmap.get(key);
		}

		int count = 0;

		// Try to include the current index in the team
		if (first == -1) {
			count += countTeams(rating, currentIndex + 1, currentIndex, second, third, hmap);
		} else if (second == -1) {
			count += countTeams(rating, currentIndex + 1, first, currentIndex, third, hmap);
		} else if (third == -1) {
			count += countTeams(rating, currentIndex + 1, first, second, currentIndex, hmap);
		}

		// Skip the current index
		count += countTeams(rating, currentIndex + 1, first, second, third, hmap);
		hmap.put(key, count);
		return count;
	}

	public static void main(String[] args) {
		int[] rating = { 2, 5, 3, 4, 1 };
		System.out.println(numTeams(rating));

	}
	
	//Using 4D Array to memoize it
	 public static int numTeams1(int[] rating) {
	       int n = rating.length;
	       int[][][][] dp = new int[n+1][n+1][n+1][n+1];
	       
	       for(int[][][] temp1 : dp) {
	    	   for(int[][] temp2: temp1) {
	    		   for(int[] temp3 : temp2) {
	    			   Arrays.fill(temp3, -1);
	    		   }
	    	   }
	       }
	    return countTeams1(rating, 0, -1, -1, -1, dp);
	}

	private static int countTeams1(int[] rating, int currentIndex, int first, int second, int third,  int[][][][] dp) {
	    
	    //base case
	    if (currentIndex == rating.length) {
	        if (first != -1 && second != -1 && third != -1) {
	            if ((rating[first] < rating[second] && rating[second] < rating[third]) || 
	                (rating[first] > rating[second] && rating[second] > rating[third])) {
	                return 1;
	            }
	        }
	        return 0;
	    }
	    
	    if(first != -1 && second != -1 && third != -1) {
	    	if(dp[currentIndex][first][second][third] != -1) {
	    		return dp[currentIndex][first][second][third];
	    	}
	    }

	    int count = 0;

	    // Try to include the current index in the team
	    if (first == -1) {
	        count += countTeams1(rating, currentIndex + 1, currentIndex, second, third, dp);
	    } else if (second == -1) {
	        count += countTeams1(rating, currentIndex + 1, first, currentIndex, third, dp);
	    } else if (third == -1) {
	        count += countTeams1(rating, currentIndex + 1, first, second, currentIndex, dp);
	    }

	    // Skip the current index
	    count += countTeams1(rating, currentIndex + 1, first, second, third, dp);
	    if(first != -1 && second != -1 && third != -1) {
	    	dp[currentIndex][first][second][third] = count;
	    }
	    
	    return count;
	}

}
