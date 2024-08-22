package com.wissen.arrays;

public class MergeSortedArrays {
	/*
	 * Intuition: Place the largest element at last indexes from both of the array &
	 * move the pointer of the arr having greater value(arr1) than element of second
	 * array(arr2) & K will always move one step back. If there were some remaining
	 * elements in arr2 then copy the all elements of arr2 into arr1 from last index
	 * (j into k).
	 */
	//TC: O(m+n)
	//SC: O(1)
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
	    int i = m - 1; // Pointer for nums1 starting from last index of where non zero elements 
	    //are present
	    int j = n - 1; // Pointer for nums2
	    int k = m + n - 1; // Pointer for the merged array
	    
	    if(n == 0) {
	    	return;
	    }

	    while (i >= 0 && j >= 0) {
	        if (nums1[i] > nums2[j]) {
	            nums1[k] = nums1[i];
	            i--;
	        } else {
	            nums1[k] = nums2[j];
	            j--;
	        }
	        k--;
	    }

	    // If there are remaining elements in nums2
	    while (j >= 0) {
	        nums1[k] = nums2[j];
	        j--;
	        k--;
	    }
	}
	    
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};  //{1,2,2,3,4,6}
		int[] nums2 = {2,5,6};
		int[] nums3 = {7,8,9,0,0,0}; //{2,5,6,7,8,9}
		int m =3;
		int n = nums2.length;
		
		merge(nums3, m, nums2, n);
		for(int val: nums3) {
			System.out.print(val + " ");
		}
		System.out.println();

	}

}

//Test case in this case i will exhausted
//Ex: 1 
//nums3 = {7,8,9,0,0,0};  
//nums2 = {2,5,6};
//o/p: [2 5 6 7 8 9]

//Ex: 2
//nums3 = {1,2,3,0,0,0};  
//nums2 = {2,5,6};
//o/p: [1 2 2 3 5 6]
