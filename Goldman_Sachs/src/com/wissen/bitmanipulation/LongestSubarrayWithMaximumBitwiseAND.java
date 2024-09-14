package com.wissen.bitmanipulation;

public class LongestSubarrayWithMaximumBitwiseAND {
	
	//TC: O(2n)
    //SC: O(1)
    public int longestSubarray(int[] nums) {
        int maxi = 0;
        int n = nums.length;
        //calculating maximum bitwise AND
        for(int val : nums) {
            maxi = Math.max(maxi, val);
        }
        int count = 0;
        int ans = 1;
        
        //calculating longest subarray with maximum bitwise AND
        for(int i = 0; i < n - 1; i++) {
             if(nums[i] == maxi && nums[i] != nums[i+1]) {
                 ans = 1;
             }
             else if(nums[i] == maxi) {
                   ans++;
                   count = Math.max(count, ans);
             }
        }
        count = Math.max(count, ans);
        return count;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
