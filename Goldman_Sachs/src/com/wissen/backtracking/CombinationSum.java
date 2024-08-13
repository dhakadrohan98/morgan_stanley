package com.wissen.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	 //TC: O(2^n) due to recursion
    //SC: O(n) stack space + O(2^n) to store ans
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(n-1, target, arr, ans, res);
        return res;
    }
    
    private void dfs(int indx, int target, int[] arr, List<Integer> ans, List<List<Integer>> res) {
        //base cases
        if(indx < 0) {
            return;
        }
        
        if(target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        
        //include curr element & remain at the same index
        if(arr[indx] <= target) {
            ans.add(arr[indx]);
            //move ahead
            dfs(indx, target - arr[indx], arr, ans, res);
            //while backtrack remove last elements from list(ans)
            ans.remove(ans.size() - 1);
        }
        //exclude curr elements & move to the next index
        dfs(indx-1, target, arr, ans, res);
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
