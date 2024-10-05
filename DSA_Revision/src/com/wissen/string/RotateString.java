package com.wissen.string;

import java.util.Arrays;

public class RotateString {
	
	//TC: O(n)
    //SC: O(n)
    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        //edge case
        if(m != n) {
            return false;
        }
        
        for(int i=0; i<n; i++) {
            //At a time new rotate String is getting created only.
            String rotate = s.substring(i+1, m) + s.substring(0, i+1);
            
            if(goal.equals(rotate)) {
                return true;
            }
            Arrays.sort();        }
        return false;
    }
    
	public static void main(String[] args) {
		
	}

}
