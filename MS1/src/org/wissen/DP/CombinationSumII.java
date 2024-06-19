package org.wissen.DP;

import java.util.*;

public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //sort the given array
        Arrays.sort(candidates);
        //recursive call
        helper(0, target, candidates, list, res);
        return res;
    }
    
    public void helper(int indx, int target, int[] nums, List<Integer> list, List<List<Integer>> res) {
        
        //base case
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=indx; i<nums.length; i++) {
            //checks for same element
            if(i > indx && nums[i] == nums[i-1]) {
                continue;
            }
            //target is less than curr arr elements then break here.
            if(target < nums[i]) {
                break;
            }
            
            list.add(nums[i]);
            helper(i+1, target-nums[i], nums, list, res);
            list.remove(list.size()-1);

        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
