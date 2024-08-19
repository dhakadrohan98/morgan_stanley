package com.wissen.stack;

import java.util.*;

public class AsteroidCollision_TwoPointerApproach {
	public static void main(String[] args) {
		int[] arr = { 5, 10, -5 };
		int[] arr1 = { -8, 8 };
		int[] arr2 = { 10, 2, -5 };
		System.out.println(asteroidCollision(arr));
		System.out.println(asteroidCollision(arr1));
		System.out.println(asteroidCollision(arr2));
	}

	private static List<Integer> asteroidCollision(int[] arr) {
		int n = arr.length;
		int i = n - 1;
		int j = n - 2;
		List<Integer> list = new ArrayList<>();
		boolean isBigger = false;

		while (j >= 0 && i >= 0) {
			// collision cond
			if (arr[j] > 0 && arr[i] < 0) {
				int first = Math.abs(arr[j]);
				int second = Math.abs(arr[i]);
				// 1st cond
				if (first > second) {
					if (isBigger == true && list.size() > 0) {
						list.remove(list.size() - 1);
					}
					list.add(arr[j]);
					i--;
					j--;
					isBigger = false;
				}
				// 2nd cond
				else if (first < second) {
					isBigger = true;
					list.add(arr[i]);
					j--;
				}
				// 3rd cond
				else { // first == second
					i -= 2;
					j -= 2;
				}
			}
			// no collision is there
			else {
				i -= 1;
				j -= 1;
			}
		}

		// if j == -1 && i == 0
		if (j == -1 && i == 0) {
			list.add(arr[i]);
		}

		return list;
	}
}