package com.wissen.two.pointers;

public class PartitionArrIntoTwoDisjointIntervals {

	public static int partitionDisjoint(int[] nums) {
		int n = nums.length;
		int[] leftMax = new int[n];
		int[] rightMin = new int[n];
		int partition = 0;

		int lMax = Integer.MIN_VALUE;
		int rMin = Integer.MAX_VALUE;
		for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
			if (lMax < nums[i]) {
				lMax = nums[i];
			}
			leftMax[i] = lMax;

			if (nums[j] < rMin) {
				rMin = nums[j];
			}
			rightMin[j] = rMin;
		}
		
		//debugger start
		System.out.println("leftMax");
		for(int num: leftMax) {
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.println("rightMin");
		for(int num: rightMin) {
			System.out.print(num + " ");
		}
		System.out.println();
		//debugger end

		for (int k = 0; k < n - 1; k++) {
			int left = leftMax[k];
			int right = rightMin[k + 1];
			if(left <= right) {
				partition = k;
				break;
			}
		}
		return partition+1;
	}

	public static void main(String[] args) {
		int[] nums = {5,0,3,8,6};
		int[] nums1 = {1,1,1,0,6,12};
		System.out.println(partitionDisjoint(nums1));

	}

}
