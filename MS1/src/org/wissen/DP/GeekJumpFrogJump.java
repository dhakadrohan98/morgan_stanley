package org.wissen.DP;

import java.util.*;

public class GeekJumpFrogJump {

	   public int minimumEnergy(int[] arr,int n){
	        int[] dp = new int[n];
	        Arrays.fill(dp, -1);
	        return helper(n-1, arr, dp);
	    }
	    
	    public int helper(int indx, int[] arr, int[] dp) {
	        //base case
	        if(indx <= 0) {
	            return 0;
	        }
	        if(dp[indx] != -1) {
	            return dp[indx];
	        }
	        
	        int left = Integer.MAX_VALUE;
	        if(indx >= 1) {
	            left = Math.abs(arr[indx]-arr[indx-1]) + helper(indx-1,arr, dp);
	        }
	        int right = Integer.MAX_VALUE;
	        if(indx >= 2) {
	            right = Math.abs(arr[indx]-arr[indx-2]) + helper(indx-2,arr, dp);
	        }
	        int min = Math.min(left, right);
	        dp[indx] = min;
	        return min;
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//hashmap memoization approach
	public int minimumEnergy1(int[] arr,int n){
        Map<Integer, Integer> hmap = new HashMap<>();
        return helper1(n-1, arr, hmap);
    }
    
    public int helper1(int indx, int[] arr, Map<Integer, Integer> hmap) {
        int key = indx;
        //base case
        if(indx <= 0) {
            return 0;
        }
        if(hmap.containsKey(key)) {
            return hmap.get(key);
        }
        
        int left = Integer.MAX_VALUE;
        if(indx >= 1) {
            left = Math.abs(arr[indx]-arr[indx-1]) + helper1(indx-1,arr, hmap);
        }
        int right = Integer.MAX_VALUE;
        if(indx >= 2) {
            right = Math.abs(arr[indx]-arr[indx-2]) + helper1(indx-2,arr, hmap);
        }
        int min = Math.min(left, right);
        hmap.put(key, min);
        return min;
    }

}
