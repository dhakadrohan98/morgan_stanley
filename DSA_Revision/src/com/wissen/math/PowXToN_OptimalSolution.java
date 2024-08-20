package com.wissen.math;

public class PowXToN_OptimalSolution {
	
	//TC: O(2*logn)
    //SC: O(logn)
    public double myPow(double x, int n) {
        
        if(n >= 0) {
            return positive(x, n);
        }
        else { // n < 0
            return negative(x,n);
        }
    }
    
    private double positive(double x, int n) {
        //base case
        if(n == 0) {
            return 1;
        }
        
        double smallOutput = positive(x, n/2);
        //if n is even
        if(n%2 == 0) {
          return  smallOutput * smallOutput;
        }
        else {
            return x * smallOutput * smallOutput;
        }
    }
    
    private double negative(double x, int n) {
        //base case
        if(n == -1) {
            return 1/x;
        }
        
        double smallOutput = negative(x, n/2);
        //if n is even
        if(n%2 == 0) {
          return  smallOutput * smallOutput;
        }
        else {
            return (1/x) * smallOutput * smallOutput;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
