package org.backtracking;

import java.util.Scanner;

public class TowerOfHanoi {

	public static int towerOfHanoiRec(int n, int start, int middle, int end) {
        //base case
        if(n == 0 || n == 1) {
            return n;
        }
        int moves = 0;
        moves += towerOfHanoiRec(n-1, start, middle, end);
        moves += 1;
        moves += towerOfHanoiRec(n-1, middle, start, end);
        return moves;
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int start = 1;
		int middle = 2;
		int end = 3;
		System.out.println(towerOfHanoiRec(n, start, middle, end));

	}

}
