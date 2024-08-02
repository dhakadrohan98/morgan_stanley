package com.wissen.math;

public class NumberPairsDivisibleBy60 {
	
	public static int numPairsDivisibleBy60(int[] nums) {
        int[] remainderMap = new int[60];
        int n = nums.length;
        
        for(int i=0; i<n; i++) {
            int indx = nums[i] % 60;
            remainderMap[indx] += 1;
        }
        int ans = 0;
        //20 -> 40
        //40 -> 60
        //count above one as one pair
        
        //To avoid from duplicate pair of song, loop will run from 1 till 29;
        // arr[1] = 3;  arr[59] = 2;
        //total 6 pairs of songs are valid 
        for(int i=1; i<30; i++) {
            // arr[10] = 4;  arr[50] = 5;
            //total 20 pairs of songs are valid
            ans += remainderMap[i] * remainderMap[60-i];
        }
        //nc2 -> (n * (n-1)) / 2;  arr[n-1]=0;
        if(remainderMap[0] > 0) {
            ans += (remainderMap[0] * (remainderMap[0] - 1)) / 2;
        }
         //pc2 -> (p * (p-1)) / 2; arr[p-1]=30
        if(remainderMap[30] > 0) {
            ans += (remainderMap[30] * (remainderMap[30] - 1)) / 2;
        }
      
        return ans;
    }
	
	public static void main(String[] args) {
		int[] nums = {30,20,150,100,40};
		System.out.println(numPairsDivisibleBy60(nums));
		
		int[] nums1 = {60,60,60,60};
		System.out.println(numPairsDivisibleBy60(nums1));
		
		int[] nums2 = {30,30,30};
		System.out.println(numPairsDivisibleBy60(nums2));

	}

}
