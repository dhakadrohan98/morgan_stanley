package com.wissen.blind75;

public class MaximumProductSubarray {

	//TC: O(n)
    //SC: O(n)
	public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int ans = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];
        
        for(int i=1; i<n; i++) {
        //if current element is negative then swap maxProd with minProd
            //because minProd * -ve = +ve
            if(nums[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            
            maxProd = Math.max(nums[i], nums[i] * maxProd);
            minProd = Math.min(nums[i], nums[i] * minProd);
            ans = Math.max(ans, maxProd);
        }
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
