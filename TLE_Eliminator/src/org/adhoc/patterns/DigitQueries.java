package org.adhoc.patterns;

import java.util.Scanner;

public class DigitQueries {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		while(q-- > 0) {
			//main logic
			long k = sc.nextLong();
			long original_pos_in_series = k;
			if(k <= 9) {
				System.out.println(k);
				continue;
			}
			
			int digit = 0;
			long powerTen = 1;
			while(true) {
				digit++;
				long chars = (9l) * digit * powerTen;
				//find the no. of digits
				if(k <= chars) {
					//find the actual number
					long number = powerTen + ((k + digit - 1) / digit) - 1;
					String s = String.valueOf(number);
					//find the index in the actual number
					int kthdigit = (k % digit == 0) ? (int)(digit - 1) : (int)((k % digit) - 1);
					System.out.println("q - "+ original_pos_in_series + ": kthdigit: " + kthdigit);
					char ans = s.charAt(kthdigit);
					System.out.println(ans);
					break;
				}
				k -= chars;
				powerTen *= 10l;
			}
		}

	}

}

//TC

//6
//7
//19
//12
//18
//25
//27