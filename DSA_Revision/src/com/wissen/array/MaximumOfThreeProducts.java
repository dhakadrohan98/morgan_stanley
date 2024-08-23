package com.wissen.array;

public class MaximumOfThreeProducts {
	
	//TC: O(n)
    //SC: O(1)
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int n = nums.length;
        int i=0;
        
        while(i < n) {
            //keep track of max1, max2, max3
            if(max1 < nums[i]) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if(max2 < nums[i]) {
                max3 = max2;
                max2 = nums[i];
            }
            else if(max3 < nums[i]) {
                max3 = nums[i];
            }
            
            //keep track of min1, min2, min3
            if(min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            }
            else if(min2 > nums[i]) {
                min2 = nums[i];
            }
                
            i++;
        }
       
        //Now do the calculation for max & min values to find the greater product
        int firstProd = max3 * max2 * max1;
        int secondProd = min1 * min2 * max1;
        
        if(firstProd > secondProd) {
            return firstProd;
        } else {
            return secondProd;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
