package org.wissen.DP;

import java.util.*;

//recursive solution, try to build intuition behind it through dry run.
public class BuySellStock_II {
	
	public int maxProfit(int[] prices) {
	       Map<String, Integer> hmap = new HashMap<>();
	       int ans = rec(prices, 0, true, hmap);
	       return ans;
	    }
	    
	    private int rec(int[] prices, int i, boolean buyOrSell, Map<String, Integer> hmap) {
	        String key = i+"_"+buyOrSell;
	        //base case
	        if(i == prices.length) {
	            return 0;
	        }
	        if(hmap.containsKey(key)) {
	            return hmap.get(key);
	        }
	        
	        int maxProfit = 0;
	        if(buyOrSell) {
	            int buy = rec(prices, i+1, false, hmap) - prices[i];
	            int skip = rec(prices, i+1, true, hmap);
	            maxProfit = Math.max(buy, skip);
	            hmap.put(key, maxProfit);
	        } else {
	            int sell = prices[i] + rec(prices, i+1, true, hmap);
	            int skip = rec(prices, i+1, false, hmap);
	            maxProfit = Math.max(sell, skip);
	            hmap.put(key, maxProfit);
	        }
	        return maxProfit;
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
