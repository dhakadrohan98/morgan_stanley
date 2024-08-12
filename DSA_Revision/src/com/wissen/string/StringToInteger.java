package com.wissen.string;

public class StringToInteger {
	
	//TC: O(2*n)
    //SC: O(1)
    public int myAtoi(String s) {
        //remove any leading & tailing whitespaces
        s = s.trim();
        //edge case
        if(s.length() == 0) {
            return 0;
        }
        boolean neg = false;
        long ans = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            //check for negative/positive character at 0th index of string s
            if(i == 0) {
                if(ch == '-') {
                    neg = true;
                    continue;
                } else if(ch == '+') {
                    neg = false;
                    continue;
                }
            }
            
            if(ch >= '0' && ch <= '9') {
                int digit = ch - '0';
                ans = ans * 10 + digit;
                
                //check if has ans crossed -2^31 to (2^31 - 1) range or not
                if(neg == true) { //if ans 
                    long check = -ans;
                    if(check < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } 
                else { // ans is positive
                    if(ans > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            else {
                break;
            }
        } //for loop end
        
        if(neg == true) {
            ans = -ans;
        }
        return (int)ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
