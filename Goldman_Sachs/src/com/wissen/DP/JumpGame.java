package com.wissen.DP;

public class JumpGame {

	//TC: O(n)
	//SC: O(1)
	public boolean canJump(int[] nums) {
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
		// TODO Auto-generated method stub

	}

}
