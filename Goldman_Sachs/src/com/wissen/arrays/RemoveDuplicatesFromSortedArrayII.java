package com.wissen.arrays;

public class RemoveDuplicatesFromSortedArrayII {
	
	//TC: O(n)
    //SC: O(1)
    public static int removeDuplicates(int[] nums) {
        int i=0;
        for(int e: nums) {
            if(i==0 || i == 1 || e != nums[i-2]) {
                nums[i] = e;
                i++;
            }
        }
        return i;
    }
    
	public static void main(String[] args) {
		int[] nums1 = {1,1,1,2,2,3}; //expected: 5
		int[] nums2 = {0,0,1,1,1,1,2,3,3}; //expected: 7
		
		System.out.println(removeDuplicates(nums1));
		System.out.println(removeDuplicates(nums2));

	}

}
