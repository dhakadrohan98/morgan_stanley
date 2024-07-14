package com.wissen.two.pointers;

public class ContainersWithMostWater {
	//TC: O(n)
    //SC: O(1)
    public int maxArea(int[] nums) {
        int maxi = 0;
        int n = nums.length;
        int i=0, j=n-1;
        
        while(i < j) {
                       //length * breadth
            int curr = (j-i) * Math.min(nums[i], nums[j]);
            maxi = Math.max(curr, maxi);
            if(nums[i] <= nums[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxi;
    }
}
