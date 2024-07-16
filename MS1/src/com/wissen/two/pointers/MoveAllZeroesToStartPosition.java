package com.wissen.two.pointers;

public class MoveAllZeroesToStartPosition {
	
	//TC: O(n)
    //SC: O(1)
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int i=0, j=1;
        
        while(i < n && j < n) {
            if(nums[i] == 0 && nums[j] != 0) {
                i++;
                j++;
            }
            else if(nums[i] == 0 && nums[j] == 0) {
            	i++;
                j++;
            } else if(nums[i] != 0 && nums[j] == 0) {
            	swap(nums, i ,j);
                i++;
                j++;
            } else if(nums[i] != 0 && nums[j] != 0) {
                i++;
                j++;
            }
        }
    }
    
    private static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		int[] nums1 = {1,0};
		int[] nums2 = {1,2};
		int[] nums3 = {0,0,1};
		moveZeroes(nums3);
		
		for(int val : nums3) {
			System.out.println(val);
		}

	}

}
