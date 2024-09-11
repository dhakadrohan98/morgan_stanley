package com.wissen.bitmanipulation;

public class CountSetBit {

	public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1); // Clear the lowest set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 12; // Example: binary representation of 12 is 1100
        int num1 = 14; // binary -> 01110
        int num2 = 29; // binary -> 11110 = 16 + 8 + 4 + 1
        System.out.println("Number of set bits: " + countSetBits(num2));
    }

}
