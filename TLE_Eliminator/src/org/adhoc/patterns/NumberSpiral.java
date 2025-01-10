package org.adhoc.patterns;

import java.util.Scanner;

public class NumberSpiral {

	private static void solve(Scanner sc) {
		long row = sc.nextLong();
		long col = sc.nextLong();
		//main logic
		if(row >= col) {
			if((row & 1) == 0) { //if row is even
				long first = row * row;
				System.out.println(first - col + 1l);
			} else { //if row is odd
				long first = ((row - 1) * (row - 1)) + 1l;
				System.out.println(first + col - 1l);
			}
		} else { // col >= row
			if((col & 1) != 0) { // if col is odd
				long first = col * col;
				System.out.println(first - row + 1l);
			} else {
				long first = ((col - 1) * (col - 1)) + 1l;
				System.out.println(first + row - 1l);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			solve(sc);
		}

	}

}
