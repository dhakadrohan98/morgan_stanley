package org.wissen.DP;

import java.util.*;

public class CombinationSumV_1 {
	public List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        rec(n-1, target, nums, list, ans);
        return ans;
    }
    
    public void rec(int indx, int target,int[] nums, List<Integer> list, List<List<Integer>> ans) {
        //base cases
        
       if(indx < 0) {
           if(target == 0) {
               ans.add(new ArrayList<>(list));
           }
           return;
       }
        
        //include
        if(nums[indx] <= target) {
            list.add(nums[indx]);
            rec(indx, target - nums[indx], nums, list, ans);
            list.remove(list.size()-1);
        }
        //exclude
        rec(indx-1, target, nums, list, ans);
    }
}
