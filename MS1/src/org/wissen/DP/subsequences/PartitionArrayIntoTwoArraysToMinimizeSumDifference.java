package org.wissen.DP.subsequences;

public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {
	
	class Solution {
	    static int minDiff = Integer.MAX_VALUE;
	    
	    public int minimumDifference(int[] nums) {
	         int n = nums.length;
	         isSubSetSum(n, nums);
	         return minDiff;
	    }
	    
	    public void isSubSetSum(int n, int nums[]){
	        // Create a DP table with dimensions [n][k+1]

	        // Initialize DP table with -1 (unprocessed)
	        
	        int totalSum = 0;
	        for(int i=0; i<n; i++) {
	            totalSum += nums[i];
	        }
	        // Call the recursive helper function
	        rec(n - 1, totalSum, 0, nums);
	    }
	    
	    public int rec(int indx, int totalSum, int currSum, int[] nums) {
	        // base case
	        if(indx < 0) {
	            return 0;
	        }

	        // If the result for this subproblem has already been calculated, return it
	        // if (dp[ind][target] != -1) {} 

	        // include the current element to currSum
	        currSum += nums[indx] + rec(indx-1, totalSum, currSum, nums);
	        int firstPart = currSum;
	        int secondPart = totalSum - currSum; 
	        int leftAbs = Math.abs(firstPart - secondPart);
	        minDiff = Math.min(minDiff, leftAbs);
	        
	        // Not include the current element to currSum
	        currSum += rec(indx-1, totalSum, currSum, nums);
	        int notFirstPart = currSum;
	        int notSecondPart = totalSum - currSum; 
	        int rightAbs = Math.abs(notFirstPart - notSecondPart);
	        minDiff = Math.min(minDiff, rightAbs);

	        // Store the result in the DP table and return whether either option was successful
	        return currSum;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
