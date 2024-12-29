package org.adhoc.patterns;

import java.util.Scanner;

public class MultiplePowersOfTwo {

	//TC: O(q*31) where q <= 31
	//SC: O(1)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] arr = new long[n];
        //take input for array
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        
        int maxi = 32;
        while(q-- > 0) {
            int qi = sc.nextInt();
            //if qi=29 & maxi = 27 then skip this part because higher power(qi) of 2 can not divide the 2^maxi
            if(qi >= maxi) {
                continue;
            }
            maxi = qi;
            for(int i = 0; i < n; i++) {
            	if((arr[i] & (1 << qi) -1) == 0) {
            		arr[i] += ((1 << qi) - 1);
            	}
            }
        }
        
        //print the array
        for(int i = 0; i <n; i++) {
        	System.out.print(arr[i] + " ");
        }
        sc.close();

	}

}
