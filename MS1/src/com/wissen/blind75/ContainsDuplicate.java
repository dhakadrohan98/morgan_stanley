package com.wissen.blind75;

import java.util.*;
public class ContainsDuplicate {

	//TC: O(n)
    //SC: O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        
        for(int i=0; i<n; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            }
            else {
                return true;
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
