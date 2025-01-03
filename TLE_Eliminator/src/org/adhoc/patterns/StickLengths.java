package org.adhoc.patterns;

import java.util.Arrays;
import java.util.Scanner;

public class StickLengths {

	//TC: O(n * logn)
	//SC: O(1)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		//take input for array arr
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//main logic
		//sort the array then 
		Arrays.sort(arr);
		//find the median
		double median = 0;
		long answer = 0;
		//if n is even
		if((n & 1) != 1) {
			median = ((double)arr[(n / 2) - 1] + (double)arr[n / 2]) / 2.0;
		}
		else { //n is odd
			median = (double)arr[n / 2];
		}
		
		for(int i =0 ; i < n; i++) {
			answer += Math.abs(arr[i] - median);
		}
		System.out.println(answer);
		sc.close();
	}

}
