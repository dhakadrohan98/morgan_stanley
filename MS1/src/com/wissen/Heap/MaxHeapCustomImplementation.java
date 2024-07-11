package com.wissen.Heap;

public class MaxHeapCustomImplementation {

	//insert into max heap is implemented
	public static int[] insert(int[] arr, int val) {
		int n = arr.length;
		int[] arr1 = new int[n+1];
		
		for(int i=0; i<arr.length; i++) {
			arr1[i] = arr[i];
		}
		
		arr1[arr1.length-1] = val;
		int i = arr1.length-1;
		
		while(i > 0) {
			int parent = (i-1)/2;
			if(arr1[parent] < arr1[i]) {
				swap(arr1, parent, i);
				i = parent;
			}
			else {
				break;
			}
		}
		return arr1;
	}
	
	private static void swap(int[] arr, int parent, int i) {
		int temp = arr[parent];
		arr[parent] = arr[i];
		arr[i] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {50, 40, 45, 30, 20, 35, 10};
		int val = 5;
		//insert(5)
		arr = insert(arr, val);
		for(int temp : arr) {
			System.out.print(temp + " ");
		}
		System.out.println();
		
		int val1 = 60;
		//insert(60)
		arr = insert(arr, val1);
		for(int temp : arr) {
			System.out.print(temp + " ");
		}
		System.out.println();
		
		int val2 = 45;
		//insert(45)
		arr = insert(arr, val2);
		for(int temp : arr) {
			System.out.print(temp + " ");
		}
		
		
		

	}

}
