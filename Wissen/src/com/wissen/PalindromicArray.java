package com.wissen;

public class PalindromicArray {
	//TC: O(n^2)
	//SC: O(1)
	public static int palinArray(int[] arr, int n)
    {
        for(int i=0; i<arr.length; i++) {
            int num = arr[i];
            int rev = 0;
            while(num != 0) {
                int rem = num % 10;
                rev = rev*10 + rem;
                num = num / 10;
            }
            
            if(arr[i] != rev) {
                return 0;
            }
        }
        return 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
