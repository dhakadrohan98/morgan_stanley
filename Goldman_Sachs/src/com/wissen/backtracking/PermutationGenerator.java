package com.wissen.backtracking;

import java.util.*;
public class PermutationGenerator {
	
	public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        //keep track of visited element at particular call of recursive fun
        boolean[] vis = new boolean[n];
        recurPermute(nums, ds, ans, vis);
        
        return ans;
    }
    
    private void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] vis) {
        //base case
        if(ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
                    
        for(int i = 0; i < nums.length; i++) {
            if(!vis[i]) {
                //makr curr element as visited
                ds.add(nums[i]);
                vis[i] = true;
                recurPermute(nums, ds, ans, vis);
                //while backtrack unmark from visited array & remove curr element from ds
                ds.remove(ds.size() - 1);
                vis[i] = false;
            }
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
