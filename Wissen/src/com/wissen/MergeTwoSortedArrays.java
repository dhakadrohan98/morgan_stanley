package com.wissen;

import java.util.*;
public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {0,0,0,1,2,3,4,7};
		int[] nums2 = {0,0,4,6,7,9,9,9,10,11};
		int n1= nums1.length;
		int n2 = nums2.length;
		
	    int[] res = new int[n1+n2];
		int i=0, j=0, k=0;
		
		while(i < n1 && j < n2) {
			
			if(nums1[i] == 0 && nums1[i] <= nums2[j]) {
				i++;
				continue;
			} else if(nums2[j] == 0 && nums1[i] > nums2[j]) {
				j++;
				continue;
			}else if(nums1[i] != 0 && nums1[i] <= nums2[j]) {
				res[k] = nums1[i];
				i++;
				k++;
			} else if(nums2[j] != 0 && nums1[i] > nums2[j]) {
				res[k] = nums2[j];
				j++;
				k++;
			}
		}
		
		while(i < n1 && nums1[i] != 0) {
			res[k++] = nums1[i++];
		}
		while(j < n2 && nums2[j] != 0) {
			res[k++] = nums2[j++];
		}
		
		for(int val: res) {
			System.out.print(val + " ");
		}
		

	}

}
