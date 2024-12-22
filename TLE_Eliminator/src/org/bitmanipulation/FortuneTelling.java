package org.bitmanipulation;

import java.util.Scanner;

//TC: O(n)
//SC: O(1)

//DIV-2
//1634/B
public class FortuneTelling {

    private static void solve(Scanner sc) {
        int n = sc.nextInt();
        long x = sc.nextLong();
        long y = sc.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        // Calculate the parity of the array
        boolean isOddParity = true; // true means even parity, false means odd parity
        for (int i = 0; i < n; i++) {
            if ((arr[i] & 1) == 1) { // Check if the number is odd
                isOddParity = !isOddParity; // Toggle the parity
            }
        }

        // Determine the winner based on the parity of x and y
        if ((x & 1) == 1) { // x is odd
            if (isOddParity == ((y & 1) == 1)) { // Same parity
                System.out.println("Alice");
            } else {
                System.out.println("Bob");
            }
        } else { // x is even
            if (isOddParity == ((y & 1) == 1)) { // Same parity
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}

//Test case:

//4
//1 7 9
//2
//2 0 2
//1 3
//4 0 1
//1 2 3 4
//2 1000000000 3000000000
//1000000000 1000000000

