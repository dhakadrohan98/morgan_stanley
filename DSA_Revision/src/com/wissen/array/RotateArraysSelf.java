package com.wissen.array;

public class RotateArraysSelf {
	
	public void rotate(int[] nums, int k) {
        int n = nums.length;
        //base case
        if(n == 1) {
            return;
        }
        
        k = k % n;
        //reverse the whole array
        reverse(0, n-1, nums);
        //reverse the left portion of arrar(0,1,..,k-1)
        reverse(0, k-1, nums);
        //reverse the right portion of arrar(k,k+1,..,n-1)
        reverse(k, n-1, nums);
    }
    
    private void reverse(int start, int end, int[] nums) {
        int len = end - start + 1;
        int count = 0;
        int i = start, j = end;
        while(count < len/2) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
            count++;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
