package com.wissen;

public class BuyAndSellStock_MAXProfitVariant {

	//TC: O(n)
	//SC: O(n)
	public int maxProfit(int[] prices) {
        //base case
        if(prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int total = 0;
        int buy = prices[0];
        
        for(int i=1; i<n; i++){
            int currProfit = prices[i] - buy;
            if(currProfit > 0) {
                total += currProfit;
            }
            //update buy value with current day stock price
            buy = prices[i];
        }
        return total;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
