package org.codeship.IBM;

public class ClosedPath {

	public static int closedPaths(int number) {
        // Array to map digits to their closed paths count
        int[] closedPathsCount = new int[10];
        closedPathsCount[0] = 1;
        closedPathsCount[4] = 1;
        closedPathsCount[6] = 1;
        closedPathsCount[9] = 1;
        closedPathsCount[8] = 2;

        // Initialize the total closed paths count
        int totalClosedPaths = 0;

        // Iterate over each digit in the number
        while (number > 0) {
            int digit = number % 10;
            totalClosedPaths += closedPathsCount[digit];
            number /= 10;
        }

        return totalClosedPaths;
    }

    public static void main(String[] args) {
        // Sample Inputs
        System.out.println(closedPaths(630));  // Output: 2
        System.out.println(closedPaths(1288)); // Output: 4
    }

}
