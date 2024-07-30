package com.wissen.binarysearch;

public class MergeTwoSortedArraysOptimlaSolution {
	
	 //TC: min(O(logm), O(logn))
    //SC: O(1)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //check for shorter length array
        if(n1 > n2) {
            //swaping the arryas
            return findMedianSortedArrays(nums2, nums1);
        }
        int totalSize = n1 + n2;
        int low =0, high = n1;
        int leftHalfPortionSize = (n1+n2+1)/2;
        while(low <= high) {
            int mid1 = (low + high)/2;
            int mid2 = leftHalfPortionSize - mid1;
             //calculate l1, l2, r1 and r2;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(mid1 < n1) { r1 = nums1[mid1]; }
            if(mid2 < n2) { r2 = nums2[mid2]; }
            if(mid1 - 1 >= 0) { l1 = nums1[mid1-1]; }
            if(mid2 - 1 >= 0) { l2 = nums2[mid2-1]; }
            //if found right symmetry/partitioning
            if(l1 <= r2 && l2 <= r1) {
                if(totalSize % 2 == 1) {
                    return (double)Math.max(l1,l2);   
                } else {
                    //keep ans will be in decimal that's why type case before multiplication
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else { //if not found right symmetry/partitioning
                if(l1 > r2) high = mid1 - 1;
                else low = mid1 + 1;
            }
        }
        return 0.0;
    }
    
	public static void main(String[] args) {
		int[] nums1 = {1,3,4,7,10,12};
		int[] nums2 = {2,3,6,15};
		
		int[] nums3 = {1,3};
		int[] nums4 = {2};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));

	}

}
