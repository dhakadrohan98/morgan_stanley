package com.wissen.blind75;

public class SearchInRotatedSortedArrayV_2 {

	//TC: O(logn)
	//SC: O(1)
	public int search(int[] arr, int target) {
        int ans = -1;
        // Arrays.sort(arr);
        int n = arr.length;
        int low = 0, high = n-1;
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(arr[mid] == target) {
                return mid;
            }
            //left half is sorted
            if(arr[low] <= arr[mid]) {
                if(target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            //right half is sorted
            else if(arr[mid+1] <= arr[high]) {
                if(target >= arr[mid+1] && target <= arr[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
