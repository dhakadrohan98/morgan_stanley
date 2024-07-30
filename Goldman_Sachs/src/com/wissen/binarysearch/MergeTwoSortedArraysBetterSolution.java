package com.wissen.binarysearch;

public class MergeTwoSortedArraysBetterSolution {
	//Better solution
	//TC: O(m+n)
	//SC: O(m+n)
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		int total = n1 + n2;
		int[] res = new int[n1 + n2];
		int i = 0, j = 0, k = 0;
		double ans = 0;

		// merge two sorted array into sorted order(Incr. order)
		while (i < n1 && j < n2) {
			if (nums1[i] <= nums2[j]) {
				res[k] = nums1[i];
				i++;
			} else {
				res[k] = nums2[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			res[k] = nums1[i];
			i++;
			k++;
		}

		while (j < n2) {
			res[k] = nums2[j];
			j++;
			k++;
		}

		for (int val : res) {
			System.out.print(val + " ");
		}
		System.out.println();

		if (total % 2 == 0) { // total even no. of elements
			double first = res[total / 2];
			double sec = res[(total - 1) / 2];
			ans = (first + sec) / 2;
		} else { // total odd no. of elements
			ans = res[total / 2];
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums01 = { 1, 2 };
		int[] nums02 = { 3, 4 };
		
		int[] nums11 = {1,3,4,7,10,12};
		int[] nums22 = {2,3,6,15};
		
		int[] nums001 = {1,3};
		int[] nums002 = {2};
		
		System.out.println(findMedianSortedArrays(nums001, nums002));

	}

}
