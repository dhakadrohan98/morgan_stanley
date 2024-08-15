package com.wissen.greedy;

public class LemonadeChange {
	
	//TC: O(n)
    //SC: O(1)
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        
        for(int bill : bills) {
            if(bill == 5) {
                five++;
            } else if(bill == 10) { //return 45 to customer
                if(five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else if(five > 0 && ten > 0) {  //return 15$ to customer
                five--;
                ten--;
            } else if(five >= 3) { //return three coins of $5
                five -= 3;
            } else {
                return false;
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
