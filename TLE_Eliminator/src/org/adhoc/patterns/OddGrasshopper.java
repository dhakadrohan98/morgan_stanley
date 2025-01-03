package org.adhoc.patterns;

import java.util.Scanner;

//TC: O(1)
//SC: O(1)
public class OddGrasshopper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			long x0 = sc.nextLong();
			long n = sc.nextLong();
			long final_pos = 0l;
			
			if(n % 4 == 1l) {
				final_pos = -n;
			} else if(n % 4 == 2l) {
				final_pos = 1l;
			} else if(n % 4 == 3l) {
				final_pos = n + 1l;
			} else { // n % 4 == 0
				final_pos = 0l;
			}
			//shifting of frame of reference towards +ve(even_no) & -ve(odd_no) x axis
			if((x0 & 1l) == 0l) { //if x0 is even
				final_pos = x0 + final_pos;
			} else { //if x0 is odd
				final_pos = x0 - final_pos;
			}
			System.out.println(final_pos);
		}
		sc.close();
	}

}

//test case-1

//3
//10 10
//10 99
//177 13

//TC-2
//9
//0 1
//0 2
//10 10
//10 99
//177 13
//10000000000 987654321
//-433494437 87178291199
//1 0
//-1 1

