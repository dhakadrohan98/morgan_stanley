package com.wissen.math;

import java.util.Arrays;

public class FindPivotIndex {
	
	//TC: O(2*n)
    //SC: O(n)
	public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int sum = 0;
        
        for(int i = 0; i < n; i++) {
        	sum += nums[i];
            prefixSum[i] = sum;
        }
        int total = prefixSum[n-1];
        
        System.out.println("prefix arr: " + Arrays.toString(prefixSum));
        
        //first element as pivot index
        int leftSide = 0;
        int remain = total - nums[0];
        if(leftSide == remain) {
           return 0;
        }
          
        int ans = -1;
        int rightSide = 0;
        //calculate pivot index from 1 to n-2
        for(int i = 1; i < n-1; i++) {
            //reset leftSide & rightSide variables
            leftSide = 0;
            rightSide = 0;
            
            leftSide = prefixSum[i] - nums[i];
            rightSide = total - prefixSum[i];
            
            if(leftSide == rightSide) {
            	System.out.println(leftSide + " = " + rightSide + " index : " + i);
                ans = i;
                break;
            }
        }
        
      //last element as pivot index
        if(ans == -1) {
        	 rightSide = 0;
             remain = total - nums[n-1];
             if(rightSide == remain) {
                 return n-1;
             }
        }
    
        return ans;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,7,3,6,5,6};
		System.out.println(pivotIndex(nums));
		
		int[] nums2 = {-1,-1,1,1,0,0};
		System.out.println(pivotIndex(nums2));

	}

}
