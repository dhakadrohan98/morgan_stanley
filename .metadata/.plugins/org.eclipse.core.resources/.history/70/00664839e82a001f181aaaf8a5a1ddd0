package com.wissen;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {	
		//fibonacci series within given range (4,9)
		int start = 44;
		int end = 100;
		int first = 0;
		int second = 1;
		int sum = first + second;
		
		while(sum <= end) {
			if(sum >= start) {
				System.out.println(sum);
			}
			first = second;
			second = sum;
			sum = first+sum;
		}
	}
	
	//3sum closest
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

}
