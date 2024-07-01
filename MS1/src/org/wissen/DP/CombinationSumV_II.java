package org.wissen.DP;

import java.util.*;

// make use of set as helper ds
public class CombinationSumV_II {

	public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> set = new LinkedHashSet<>();
        rec(0, target, nums, list, set);
        List<List<Integer>> ans = new ArrayList<>(set);
        set.removeAll(ans);
        return ans;
    }
    
    public void rec(int indx, int target, int[] nums, List<Integer> list, Set<List<Integer>> set) {
        //base case
        if(indx == nums.length) {
            if(target == 0) {
                set.add(new ArrayList<>(list));
            }
            return;
        }
        
        //include
        if(nums[indx] <= target) {
            list.add(nums[indx]);
            rec(indx+1, target-nums[indx], nums, list, set);
            list.remove(list.size()-1);
        }
        //exclude
        rec(indx+1, target, nums, list, set);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
