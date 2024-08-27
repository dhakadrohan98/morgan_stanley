package com.wissen.string;

public class PeformStringShifts {
	
	//TC: O(n)
	//SC: O(1)
	public static String stringShift(String s, int[][] shift) {
        int moveLeft = 0;
        int lengthOfString = s.length();
        
        for (int[] sh : shift) {
            int direction = sh[0];
            int amount = sh[1];
            if (direction == 0) {
                moveLeft += amount;
            } else {
                moveLeft -= amount;
            }
        }
        
        moveLeft = (moveLeft % lengthOfString + lengthOfString) % lengthOfString;
        System.out.println(moveLeft);
        return s.substring(moveLeft) + s.substring(0, moveLeft);
    }

    public static void main(String[] args) {
        int[][] shifts = {{0, 1}, {1, 2}};
        String str = "abcdef";
        // Output: "fabcde"
        
        int[][] shifts1 = {{0, 3}, {1, 1}, {1, 2}};
        String str1 = "hello";
        
        int[][] shifts2 = {{1, 1}, {0, 2}};
        String str2 = "xyz";
        
        String res = stringShift(str2, shifts2); 
        System.out.println(res);
    }

}
