package org.wissen.binarysearch;

public class FindMinimumInRotatedSortedArray_88_150 {
	
	public int findMin(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int mid = 0;
        while(low <= high) {
            mid = (low + high) / 2;
            if(arr[low] <= arr[mid]) {
                if(arr[mid] >= arr[high]) {
                    low = mid + 1;
                } else { // arr[mid] < arr[high]
                    high = mid;
                }
            } else { // arr[low] > arr[mid]
                if(arr[mid] < arr[high]) {
                    low = mid;
                } else { // arr[mid] >= arr[high]
                    high = mid;
                }
            }
        }
        
        return arr[mid];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
