package com.wissen.blind75;

public class SearchInRotatedSortedArray {

	//TC: O(logn)
    //SC: O(1)
    public int search(int[] nums, int target) {
        int n = nums.length;
        int ans = -1;
        int low=0, high=n-1;
        
        while(low <= high) {
            int mid = (low + high)/2;
            
            if(nums[mid] == target) {
                ans = mid;
                break;
            } 
            //left half is sorted.
            else if(nums[low] <= nums[mid])  {
                if(nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //right half is sorted.
            else if(nums[mid+1] <= target && target <= nums[high]) {
                    low = mid + 1;
              } else {
                    high = mid - 1;
                }
        }
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
