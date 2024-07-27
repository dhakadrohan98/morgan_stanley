package org.wissen.binarysearch;

public class CeilTheFloor {
	
	//TC: O(logn)
	//SC: O(1)
	public static int[] getFloorAndCeil(int[] arr, int n, int target) {
	      int[] res = new int[2];
	      int floor = -1;
	      int ceil = -1;
	      int low=0, high=n-1;

	      while(low <= high) {
	          int mid = (low + high)/2;
	          if(arr[mid] > target) { //ceil
	              ceil = arr[mid];
	              high = mid - 1;
	          } else if(arr[mid] < target) { //floor
	             floor = arr[mid];
	             low = mid + 1;
	          } else { //ceil & floor ar 
	            floor = arr[mid];
	            ceil = arr[mid];
	            break;
	          }
	      }
	      res[0] = floor;
	      res[1] = ceil;
	      return res;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
