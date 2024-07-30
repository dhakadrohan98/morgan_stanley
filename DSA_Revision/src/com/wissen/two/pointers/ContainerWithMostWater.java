package com.wissen.two.pointers;

public class ContainerWithMostWater {

	// TC: O(n)
	// SC: O(1)
	public int maxArea(int[] height) {
		int maxArea = 0;
		int n = height.length;
		int min = Integer.MAX_VALUE;
		int i = 0, j = n - 1;

		while (i <= j) {
			int breadth = j - i;
			int length = Math.min(height[i], height[j]);
			int area = breadth * length;
			maxArea = Math.max(maxArea, area);
			if (height[i] <= height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
