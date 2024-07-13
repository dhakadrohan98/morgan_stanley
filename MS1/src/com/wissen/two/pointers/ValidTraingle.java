package com.wissen.two.pointers;

import java.util.Arrays;

public class ValidTraingle {
	
	//quick sort(dual pivot)
	//TC: O(n^2) + O(n)
	//SC: O(n)
	public int triangleNumber(int[] nums) {
	       int count = 0;
	       int n = nums.length;
	        
	        //edge case
	        if(n < 3) {
	            return 0;
	        }
	        Arrays.sort(nums);
	        
	        for(int i=2; i<n; i++) {
	            int left = 0;
	            int right = i-1;
	            while(left < right) {
	                if(nums[left] + nums[right] > nums[i]) {
	                    count += (right - left);
	                    right--;
	                } else {
	                    left++;
	                }   
	            }
	        }
	        return count;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
