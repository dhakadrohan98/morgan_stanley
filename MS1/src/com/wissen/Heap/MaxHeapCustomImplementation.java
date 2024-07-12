package com.wissen.Heap;

/*Time & space complexity of Heap DS operations:
insert(): TC: O(logn)
		SC: O(n)


delete():  TC: O(logn)
		   SC: O(n)


search(): TC: O(logn)
		SC: O(n)


heapify():  TC: O(logn)
		     SC: O(1)*/
public class MaxHeapCustomImplementation {

	// TC: O(logn)
	// SC: O(n)
	// insert into max heap is implemented
	public static int[] insert(int[] arr, int val) {
		int n = arr.length;
		int[] arr1 = new int[n + 1];

		for (int i = 0; i < arr.length; i++) {
			arr1[i] = arr[i];
		}

		arr1[arr1.length - 1] = val;
		int i = arr1.length - 1;

		while (i > 0) {
			int parent = (i - 1) / 2;
			if (arr1[parent] < arr1[i]) {
				swap(arr1, parent, i);
				i = parent;
			} else {
				break;
			}
		}
		return arr1;
	}

	// TC: O(logn)
	// SC: O(n)
	public static int[] delete(int[] arr) {
		int n = arr.length;
		// take the last element to the top
		arr[0] = arr[n - 1];
		// decrease arr size by 1;
		int[] arr1 = new int[arr.length - 1];
		n = arr1.length;
		// copy from arr to arr1 due to decrement in size
		for (int i = 0; i < n; i++) {
			arr1[i] = arr[i];
		}

		int i = 0;
		// follow top-down approach to heapify()
		while (i < n) {
			int lc = Integer.MIN_VALUE;
			int rc = Integer.MIN_VALUE;

			if ((2 * i) + 1 < n) {
				lc = 2 * i + 1;
			}
			if ((2 * i) + 2 < n) {
				rc = 2 * i + 2;
			}
			// If current element is greater than or equal to lc & rc, then break at this
			// point.
			if (lc != Integer.MIN_VALUE && rc != Integer.MIN_VALUE) {
				if (arr1[i] >= arr1[lc] && arr1[i] >= rc) {
					break;
				}
			}

			if (lc != Integer.MIN_VALUE && arr1[i] < arr1[lc]) {
				swap(arr1, i, lc);
			}
			if (rc != Integer.MIN_VALUE && arr1[i] < arr1[rc]) {
				swap(arr1, i, rc);
			}
			i++;
		}
		return arr1;
	}

	private static void swap(int[] arr, int parent, int i) {
		int temp = arr[parent];
		arr[parent] = arr[i];
		arr[i] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 50, 40, 45, 30, 20, 35, 10 };
		int val = 5;

		// delete(50)
		arr = delete(arr);
		for (int temp : arr) {
			System.out.print(temp + " ");
		}
		System.out.println();

		// delete(45)
		arr = delete(arr);
		for (int temp : arr) {
			System.out.print(temp + " ");
		}
		System.out.println();

		/*
		 * //insert(5) arr = insert(arr, val); for(int temp : arr) {
		 * System.out.print(temp + " "); } System.out.println();
		 * 
		 * int val1 = 60; //insert(60) arr = insert(arr, val1); for(int temp : arr) {
		 * System.out.print(temp + " "); } System.out.println();
		 * 
		 * int val2 = 45; //insert(45) arr = insert(arr, val2); for(int temp : arr) {
		 * System.out.print(temp + " "); }
		 */

	}

}
