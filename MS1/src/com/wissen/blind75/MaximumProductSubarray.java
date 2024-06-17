package com.wissen.blind75;

public class MaximumProductSubarray {

	//TC: O(n)
    //SC: O(n)
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        
        for(int i=0,j=n-1; i<n && j>=0; i++,j--) {
            if(prefix == 0) {
               prefix = 1;
            }
            if(suffix == 0) {
               suffix = 1;
            }
            
            prefix *= nums[i];
            suffix *= nums[j-1];
            
            maxProd = Math.max(maxProd, Math.max(suffix, prefix));
        }
        return maxProd;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
