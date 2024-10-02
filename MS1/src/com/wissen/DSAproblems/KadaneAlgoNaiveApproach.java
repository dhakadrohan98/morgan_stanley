package com.wissen.DSAproblems;

public class KadaneAlgoNaiveApproach {
	//TC: O(n^2)
	private long maxSubarraySum(int arr[], int n){
	    
	    long largetSum = Long.MIN_VALUE;
	    for(int i=0; i<n; i++) {
	        long sum = 0;
	        for(int j=i; j<n; j++) {
	            sum += arr[j];
	            largetSum = Math.max(largetSum, sum);
	        }
	    }
	    return largetSum;
	}
}
