package com.wissen.math;

public class SieveOfEratosthenes {

	public static int countPrimes(int n) {
        //edge case
        if(n <= 2) {
            return 0;
        }
        
		boolean[] composite = new boolean[n];
		int limit = (int)Math.sqrt(n);
        
		for(int i = 2; i <= limit; i++) {
			if(composite[i] == false) {
				for(int j = i*i; j < n; j = j + i) {
					composite[j] = true;
				}
			}
		}
		
        int count = 0;
		for(int i = 2; i < n; i++) {
			if(composite[i] == false) {
				count++;
			}
		}
		return count;  
    }

	public static void main(String[] args) {
		int n = 30;
		int n1 = 10;
		int n2 = 1;
		System.out.println(countPrimes(n2));

	}

}
