package com.wissen.DP;

import java.util.*;

public class CombinationSum {
	
	//TC: O(2^n) * O(k)
	//SC: O(n)
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n = candidates.length;
        //recursive call
        helper(n-1, target, candidates, list, res);
        return res;
    }
    
    public void helper(int indx, int target, int[] nums, List<Integer> list, List<List<Integer>> res) {
        
        //base case
        if(indx < 0) {
            if(target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        
        //include
        if(nums[indx] <= target) {
            list.add(nums[indx]);
            helper(indx, target - nums[indx], nums, list, res);
            list.remove(list.size()-1);
        }
        //exclude
        helper(indx-1, target, nums, list, res);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
