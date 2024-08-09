package com.wissen.arrays;

public class RemoveDuplicatesfromSortedArray {
	
	//TC: O(n)
	//SC: O(1)
	public int removeDuplicates(int[] nums) {
        int n = nums.length;
        //base case
        if(n == 1) {
            return 1;
        }
        int i=0, j=1;
        
        while(i < n && j < n) {
            if(nums[i] != nums[j]) {
                if(i+1 < n) {
                    nums[i+1] = nums[j]; 
                }
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i+1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
