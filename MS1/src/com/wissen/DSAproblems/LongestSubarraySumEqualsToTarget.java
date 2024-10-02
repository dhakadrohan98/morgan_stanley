package com.wissen.DSAproblems;

import java.util.*;

public class LongestSubarraySumEqualsToTarget {

	//TC: O(n)
    //SC: O(n)
    public static int lenOfLongSubarr (int arr[], int n, int target) {
        int maxLen = 0;
        int prefixSum = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            prefixSum += arr[i];
            
            //if prefixSum equals to target till current index
            if(prefixSum == target) {
                maxLen = i+1;   
            } else if(hmap.containsKey(prefixSum - target)) {
                int index = hmap.get(prefixSum - target);
                int currLen = i - index;
                maxLen = Math.max(maxLen, currLen);
            }
            
            if(!hmap.containsKey(prefixSum)) {
                hmap.put(prefixSum, i);   
            }
        }
        return maxLen;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
