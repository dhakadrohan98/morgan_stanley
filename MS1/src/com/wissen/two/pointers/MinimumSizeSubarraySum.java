package com.wissen.two.pointers;

public class MinimumSizeSubarraySum {
	//TC: O(n)
    //SC O(n)
    public static int minSubArrayLen(int target, int[] nums) {
		int minLen = Integer.MAX_VALUE;
		int n = nums.length;
		int i=0, j=0;
		int sum = 0;
		
		while(j < n) {
			//calculate ans
			sum += nums[j];
			//if sum < cond
			if(sum < target) {
				j++;
			} else if(sum == target) {
				//calculate ans
				minLen = Math.min(j-i+1, minLen);
				//remove calculations for i to minimize the window
				sum -= nums[i];
				//slide the window
				i++;
				j++;
			} else {
				minLen =  Math.min(minLen, j-i+1);
				//if sum > condition
				while(sum > target) {
                    	//check for minimum len because sum >= condn is valid one
					minLen = Math.min(j-i+1, minLen);
					sum -= nums[i];
					i++;
				}
				//again check for ans
				if(sum == target) {
					minLen = Math.min(j-i+1, minLen);
					//remove calculations for i
					sum -= nums[i];
					//slide the window
					i++;
					j++;
				}
				else {
					//slide the window from rightMostSide only
					j++;
				}
			}
		}
		if(minLen == Integer.MAX_VALUE) {
			minLen = 0;
		}
		return minLen;
	}

	public static void main(String[] args) {
		// Test case 1
		int[] nums = {2, 3, 1, 2, 4, 3};
		int target = 7;
		// Test case 2
		int[] nums1 = { 1, 4, 4 };
		int target1 = 4;
		// Test case 3
		int[] nums2 = { 1, 1, 1, 1, 1, 1, 1, 1 };
		int target2 = 11;

		// test case 4
		int[] nums3 = { 1, 2, 3, 4, 5 };
		int target3 = 11;

		int ans = minSubArrayLen(target3, nums3);
		System.out.println(ans);

	}

}
