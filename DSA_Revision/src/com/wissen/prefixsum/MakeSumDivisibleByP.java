package com.wissen.prefixsum;

public class MakeSumDivisibleByP {
	
	//63_142 test cases are passed
	
	//TC: O(2*n)
	//SC: O(1)
	public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        //Edge case
        //given sum is more than or equal to sum of array, complete array can not be removed
        if(p >= sum) {
            return -1;
        }
        
        int k = sum % p;
        //no elements need to be removed as sum of given array is completely divisble by p
        if(k == 0) {
            return 0;
        }
        //Find the min length of subarray whose sum equals to k
        //Apply variable size sliding window technique
        int i = 0, j = 0;
        //reset sum again to 0 for calculating subarray sum
        sum= 0;
        int minSize = Integer.MAX_VALUE;
        while(j < n) {
            
            sum += nums[j];
            if(sum < k) {
                j++;
            } else if(sum == k) {
                minSize = Math.min(minSize, j - i + 1);
                j++;
            } else {
                //remove elements from left side of the window, 
                //shrink the window
                while(sum > k) {
                    sum -= nums[i];
                    i++;
                }
                if(sum == k) {
                    minSize = Math.min(minSize, j - i + 1);
                }
                j++;
            }
        }
        
        return minSize;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
