package com.wissen.DSAproblems;

import java.util.Arrays;

public class _3SumClosest {
	//TC: O(n^2)
    //SC: O(n)
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum =0;
        int closestDiff = Integer.MAX_VALUE;
        int n = nums.length;
        
        for(int i=0; i<nums.length-2; i++) {
            int j = i+1;
            int k = n-1;
            while(j < k) {
                int currSum = nums[i]+nums[j]+nums[k];
                int absDiff = Math.abs(currSum-target);
                if(absDiff < closestDiff) {
                    closestDiff = absDiff;
                    closestSum = currSum;
                }
                if(currSum == target) {
                    return currSum;
                }
                if(currSum < target) {
                    j++;
                } else if(currSum > target) {
                    k--;
                }
            }
        }
        return closestSum;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		int target = 1;
		System.out.println("Result: " + threeSumClosest(nums, target));

	}

}
