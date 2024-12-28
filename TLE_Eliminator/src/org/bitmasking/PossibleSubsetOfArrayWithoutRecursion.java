package org.bitmasking;

import java.util.Scanner;

public class PossibleSubsetOfArrayWithoutRecursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		//input for array
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//main logic of bitmasking
		//0 to 2^n-1
		for(int mask = 0; mask < (1 << n); mask++) {
			for(int i = 0; i < n; i++) {
				if((mask & (1 << i)) >= 1) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
		sc.close();
	}

}
