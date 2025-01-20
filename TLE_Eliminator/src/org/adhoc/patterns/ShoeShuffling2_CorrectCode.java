package org.adhoc.patterns;

import java.util.Arrays;
import java.util.Scanner;

//TC: O(t*n)
//SC: O(n)
public class ShoeShuffling2_CorrectCode {

    private static void solve(Scanner sc) {
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            long temp = arr[i];
            int size = 1;
            int start = i; //first element of each shuffling sequence
            //check for two conditions - 
			//(i) shuffling shold be done with same shoe size
			//(ii) if a shoe has frequency = 1, then return -
            while (i + 1 < n && arr[i + 1] == temp) {
                i++;
                size++;
            }
            if (size == 1) {
                System.out.println(-1);
                return;
            }
            //series of same size shoes students -
            //assign next student's shoe to prev one student & first shoe index to last student
            for (int j = start; j <= i; j++) {
                ans[j] = (j == i) ? start : j + 1;
            }
        }
        //print permutation considering 1 based indexing for ans
        for (int i = 0; i < n; i++) {
            System.out.print((ans[i] + 1) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}