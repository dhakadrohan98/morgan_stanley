package com.wissen.backtracking;

import java.util.*;
public class GenrateAllSubsetsArray {
	
	//TC: O(2^n)
    //SC: O(n)
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        dfs(0, nums, ans, ds);
        return ans;
    }
    
    private void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> ds) {
        // // Add the current subset to the answer list, Intially empty subset will be added
        ans.add(new ArrayList<>(ds));
        
        for(int itr = i; itr < nums.length; itr++) {
             ds.add(nums[itr]);
             dfs(itr+1, nums, ans, ds);
             ds.remove(ds.size() - 1);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
