package com.wissen.binarysearch;

import java.util.*;
public class KthSmallestDistanceOptimalSol {
	
	 //TC: O(n*logn) + O((high+1)(n)
    //SC: O(n) due to quick sort on primitive types
    private int slidingWindowCount(int[] nums, int dist) {
        int i = 0, j = 1;
        int n = nums.length;
        int pairCount = 0;
        //old sliding window template
        while(j < n) {
            //while pair diff. is greater than dist, then move left pointer by one step ahead. 
            while(nums[j] - nums[i] > dist) {
                i++;
            }
            pairCount += (j-i);
            j++;
        }
        
        return pairCount;
    }
    
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        //sort the given array to apply Sliding window approach
        //O(n*logn) in c++ | O(n^2) in java
        Arrays.sort(nums);
        int low = 0;
        int high = nums[n-1] -  nums[0];
        
        int result = 0;
        
        //O(high+1)
        while(low <= high) {
            int mid = (low + high)/2;
            //TC: O(n)
            int countPair = slidingWindowCount(nums, mid);
            if(countPair < k) {
                low = mid + 1;
            } else {
                result = mid;//storing the mid as the possible result
                high = mid - 1;
            }
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
