package com.wissen.blind75;

import java.util.*;
public class _3Sum {

	public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<n-2; i++) {
            int j = i + 1;
            int k = n-1;
            while(j < k) {
                List<Integer> list = new ArrayList<>();
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    set.add(new ArrayList<>(list));
                    j++;
                    k--;
                } else if(sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
