package com.wissen.blind75;

public class ContainerWithMostWater {

	//TC: O(n)
    //SC: O(1)
    public int maxArea(int[] nums) {
        int n = nums.length;
        int max = 0;
        int left = 0;
        int right = n-1;
        
        while(left < right) {
            int breadth = Math.min(nums[left], nums[right]);
            int length = right - left;
            int area = breadth * length;
            max = Math.max(max, area);
            
            if(nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
