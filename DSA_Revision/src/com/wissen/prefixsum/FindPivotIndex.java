package com.wissen.prefixsum;

public class FindPivotIndex {
	
	 //TC: O(n)
    //SC: O(n)
    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++) {
        	sum += nums[i];
            prefix[i] = sum;
        }
        int totalSum = prefix[n-1];
        //edge cases
        //1st if rightSum except first index element is equal to 0.
        if(nums[0] == totalSum) {
            return 0;
        }
        
        for(int i = 1; i < n-1; i++) {
            int leftPartitionSum = prefix[i] - nums[i];
            int rightPartitionSum = totalSum - prefix[i];
            
            if(leftPartitionSum == rightPartitionSum) {
                return i;
            }
        }
        
        //last index edge case is kept after for loop because
        //we need to find leftmost pivot index
        //2nd case: if leftSum except last index is equal to 0.
        if(totalSum == nums[n-1]) {
            return n-1;
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,7,3,6,5,6};
		System.out.println(pivotIndex(nums));
	}
}
