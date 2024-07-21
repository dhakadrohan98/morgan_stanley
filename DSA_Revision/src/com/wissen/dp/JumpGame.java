package com.wissen.dp;

public class JumpGame {
	//very tricky
	//TC: O(n)
	//SC: O(1)
	public static boolean canJump(int[] nums) {
        int maxIndex = 0;
        int n = nums.length;
        for(int i=0; i<nums.length; i++) {
            if(i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,1,1,0,2,5};
		int[] nums1 = {1,2,4,1,1,0,2,5};
		
		System.out.println(canJump(nums1));

	}

}
