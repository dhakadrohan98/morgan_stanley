package com.wissen.blind75;

public class MoveAllZeroesAtTheEnd {
	//TC: O(n)
	//SC: O(n)
	public void moveZeroes(int[] nums) {
        if(nums.length == 1) {
            return;
        }
        int n = nums.length;
        int i=0, j=1;
        
        while(j < n) {
            if(nums[i] == 0 && nums[j] != 0) {
                swap(nums, i,j);
                i++;
                j++;
            }
            else if(nums[i] != 0 && nums[j] != 0) {
                i++;
                j++;
            }
            else if(nums[i] != 0 && nums[j] == 0) {
                i++;
                j++;
            }
            else {
                j++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
