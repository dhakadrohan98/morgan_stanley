package com.wissen.variablesize.sliding.window;

public class MinimumSizeSubarraySumClearCrispCode {
	
	//TC: O(n)
    //SC: O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i=0, j=0;
        int sum = 0, min = Integer.MAX_VALUE;
        
        while(j < n) {
            //do some calculation
            sum += nums[j];
            
            if(sum < target) {
                j++;
            }
            else if(sum >= target) {
                //calculations for ans
               if(min > (j-i+1)) {
                   min = j-i+1;
               }
                //shrink the window until conditions is satisfied
                while(sum >= target) {
                    if(min > (j-i+1)) {
                        min = j-i+1;
                    }
                    sum -= nums[i];
                    i++;
                }
                j++;
            }
        }
        if(min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
