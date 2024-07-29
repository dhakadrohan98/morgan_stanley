package com.wissen.arrays;

public class MaximumSubarraySum {
	
	public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
            maxi = Math.max(maxi, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return maxi;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
