package com.wissen.dp;

import java.util.*;
public class BestTimetoBuyandSellStockII {
	
	//TC: < O(2^n)
    //SC: O(n) stack space + O(n) memoization space
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Map<String, Integer> hmap = new HashMap<>();
        return rec(0, true, prices, hmap);
    }
    
    private int rec(int indx, boolean buy, int[] prices, Map<String, Integer> hmap) {
        String key = indx +"_" + buy;
        //base case
        if(indx == prices.length) {
            return 0;
        }
        //memoization check
        if(hmap.containsKey(key)) {
            return hmap.get(key);
        }
        
        int profit = 0;
        if(buy) {
            profit = Math.max((-prices[indx]) + rec(indx+1, false, prices, hmap),
                             0 + rec(indx+1, true, prices, hmap));
        } else {
           profit = Math.max(prices[indx] + rec(indx+1, true, prices, hmap),
                             0 + rec(indx+1, false, prices, hmap)); 
        }
        hmap.put(key, profit);
        return profit;
    }
    
	public static void main(String[] args) {
		int[] nums1 = {7,1,5,3,6,4};
		int[] nums2 = {1,2,3,4,5};
		BestTimetoBuyandSellStockII obj = new BestTimetoBuyandSellStockII();
		
		System.out.println(obj.maxProfit(nums1));

	}

}
