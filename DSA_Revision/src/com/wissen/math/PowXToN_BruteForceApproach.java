package com.wissen.math;

public class PowXToN_BruteForceApproach {
	
	//brute force way
	//TC: O(n)
	//SC: O(1)
	public double myPow(double x, int n) {
        double ans = 1.0;
        boolean isNegative = false;
        if(n < 0) {
            isNegative = true;
            n = -n;
        }
        
        for(int i=0; i<n; i++) {
                ans = ans * x;
        }
        
        System.out.println(ans);
        
        if(isNegative == true) {
            ans = 1/ans;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
