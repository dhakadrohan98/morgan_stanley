package com.wissen.sorting;

public class HeightChecker_BySelf {
	
	//Tc: O(3*n)
    //SC: O(n)
    public int heightChecker(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        //freqMap will help to build the sorting sequence
        int[] freqMap = new int[max+1];
        for(int i = 0; i < n; i++) {
            freqMap[nums[i]]++;
        }
        //build the sorting sequence & store into expected array
        int[] expected = new int[n];
        int j = 0; //pointer to travers the expected array
        
        //min = 1,2,..., max indexes
        // i = 0;
        while(min < freqMap.length) {
            while(freqMap[min] != 0 && j < n) {
                expected[j] = min;
                j++;
                freqMap[min]--;
            }
            min += 1;
        }
        
        int count = 0;
        //check original array with sorted array(expected one)
        for(int k = 0; k < n; k++) {
            if(nums[k] != expected[k]) {
                count++;
            }
        }
        
        return count;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
