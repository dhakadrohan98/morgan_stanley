package org.bitmanipulation;

public class DivisibiltyCheck {

	public static void main(String[] args) {
		int[] arr = new int[]{4, 8, 16, 20, 24, 32};
		int n = arr.length;
		//n -> 1 to 6
		for(int i = 0; i < n; i++) {
			for(int div = 1; div <= n; div++) {
				int divisor = (1 << div) -1;
				if((arr[i] & divisor) == 0) {
					System.out.println(arr[i] +" is divisible by " + (1 << div));
				}
			}
			System.out.println();
		}
		
		//if a number has 7 zeroes from LSB, then is it divisble by 2^6, 2^5, 2^4,... so on.

	}

}
