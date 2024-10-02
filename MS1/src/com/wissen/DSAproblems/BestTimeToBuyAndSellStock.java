package com.wissen.DSAproblems;

public class BestTimeToBuyAndSellStock {

	//TC: O(n)
    //SC: O(n)
    public int maxProfit(int[] prices) {
        //edge case
        if(prices.length <= 1) {
            return 0;
        }
        
        int maxProfit =0;
        int purchase = prices[0];
        
        for(int i=1; i<prices.length; i++) {
            int currProfit = prices[i] - purchase;
            maxProfit = Math.max(maxProfit, currProfit);
            //update stock purchase value to minimum one
            if(prices[i] < purchase) {
                purchase = prices[i];
            }
        }
        return maxProfit;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
