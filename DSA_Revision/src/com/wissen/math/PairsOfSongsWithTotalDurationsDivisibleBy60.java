package com.wissen.math;

//8_35 test cases have been passed
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
	
	
	public static int numPairsDivisibleBy60(int[] nums) {
        int[] memo = new int[61];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int val = nums[i] % 60;
            memo[val]++;
        }
        
        for(int i=0; i<61; i++) {
            if(memo[i] != 0) {
              System.out.println("i: " + i + ", val: " + memo[i]);  
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++) {
            int pair1 = nums[i] % 60;
            int pair2 = 60 - pair1;
            if(pair1 == pair2) {
                if(memo[pair2] > 1) {
                    count++;
                    memo[pair2] -= 1;
                }
            } else if(pair2 == 60 && memo[0] > 0) {
            	count++;
            	memo[0] -= 1;
            }
            else {
                if(memo[pair2] > 0) {
                    count++;
                    memo[pair2] -= 1;
                }
            }
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {60,60,60};
		int[] nums1 = {30,20,150,100,40};
		System.out.println(numPairsDivisibleBy60(nums1));
	}
}
