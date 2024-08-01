package com.wissen.math;

public class CountPrimes {
	
//Sieve of Eratosthenes algorithm
    
    //TC: O(nloglogn)
    //SC: O(n) for keeping track of visited elements
    public int countPrimes(int n) {
        if(n <= 2) { //checking 0 & 1
            return 0;
        }
        boolean[] composites = new boolean[n];
        int limit = (int)Math.sqrt(n);
        //Array of composites --> True represent composite and false reperesents primes
        for(int i=2; i < limit; i++) {
            //TC: O(sqrt(n))
            if(composites[i] == false) {
                 //mark all the mutiples of i as true
                 //The first index to be flipped to true is i*i
                //TC: O(loglogn)
                for(int j = i*i; j < n; j = j + i) {
                   composites[j] = true;
                }
            }
        }
        
        int count = 0;
        for(int i=2; i<n; i++) {
            if(composites[i] == false) {
                count++;
            }
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
