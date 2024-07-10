package com.wissen.twopointers;

public class TrapTheRainWater {
	
	//TC: O(3*n)
    //SC: O(2*n)
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = height[0];
        int leftMax = left[0];
        for(int i=1; i<n; i++) {
           if(height[i] > leftMax) {
               leftMax = height[i];
           } 
           left[i] = leftMax;
         }
        
        right[n-1] = height[n-1];
        int rightMax = right[n-1];
        for(int i=n-2; i>=0; i--) {
           if(height[i] > rightMax) {
               rightMax = height[i];
           }
            right[i] = rightMax;
        }
        
        int maxWater = 0;
        for(int i=0; i<n; i++) {
            maxWater += Math.min(left[i], right[i]) - height[i];
        }
        return maxWater;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
