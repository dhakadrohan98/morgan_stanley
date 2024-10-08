package com.wissen.DSAproblems;

import java.util.*;

public class MoveZeroesToEnd {
	//TC: O(N)
	//SC: O(1)
	public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        
        while(right < n) {
            if(nums[right] == 0) {
                right++;
            }
            else {
                swap(nums, left, right);
                left++;
                right++;
            }
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 5, 0, 0, 4};
		int[] nums1 = {0, 0, 0, 4};
		int[] nums2 = {0,1,0,3,12};
		moveZeroes(nums);
		
		for(int val:nums) {
			System.out.println(val);
		}

	}
	
	
	//Naive approach
	
	//TC: O(n^2)
    //SC: O(1)
    public void moveZeroes1(int[] nums) {
        int n = nums.length;
        
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                for(int j=i+1; j<n; j++) {
                    if(nums[j] != 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
    }
}
