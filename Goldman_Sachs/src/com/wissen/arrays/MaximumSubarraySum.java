package com.wissen.arrays;

public class MaximumSubarraySum {
	
	public static int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;
        if(n == 0) {
        	return 1;
        }
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
		int[] nums1 = {-2,-3,4,-1,-2,1,5,-3}; //7
		int[] nusm2 = {-2,1,-3,4,-1,2,1,-5,4}; //6
		int[] nums3 = {-5,-3,-8,-9,-10,-11,-2}; //-2
		System.out.println(maxSubArray(nums3));
	}
}
