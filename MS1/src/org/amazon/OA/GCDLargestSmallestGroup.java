package org.amazon.OA;

import java.util.Arrays;

//Time Complexity: O(N \log N + N \log(\text{max element}))
//Space Complexity: O(N)
public class GCDLargestSmallestGroup {
	public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void updateArray(int[] arr) {
        int n = arr.length;
        int[] updatedArr = new int[n];
        int largest = arr[0];

        for (int i = 0; i < n; i++) {
            largest = Math.max(largest, arr[i]);
            updatedArr[i] = gcd(arr[i], largest);
        }

        System.arraycopy(updatedArr, 0, arr, 0, n);
    }
    
    public static int[] groupAndCalculateGCD(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int[] result = new int[n / 2];

        for (int i = 0; i < n / 2; i++) {
            result[i] = gcd(arr[i], arr[n - 1 - i]);
        }

        return result;
    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {14, 1, 2, 16, 10, 11, 9, 8};
        updateArray(arr);
        int[] groupedGCDs = groupAndCalculateGCD(arr);
        int finalSum = sumArray(groupedGCDs);
        System.out.println("The sum of array B: " + finalSum);
    }
}
