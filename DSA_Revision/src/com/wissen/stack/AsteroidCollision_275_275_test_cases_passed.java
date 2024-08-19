package com.wissen.stack;

import java.util.*;
public class AsteroidCollision_275_275_test_cases_passed {
	
	//TC: O(n)
    //SC: O(n)
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        
        for (int asteroid : arr) {
            boolean destroyed = false;
            
            while (!st.isEmpty() && asteroid < 0 && st.peek() > 0) {
                if (st.peek() < -asteroid) {
                    //st.top will be destroyed ans check for next top of stack with
                    //current asteroid value can it be also destroyed or not
                    st.pop();
                    continue;
                } else if (st.peek() == -asteroid) {
                    //st.top will be destroyed
                    st.pop();
                }
                //asteroid has been destroyed here.
                destroyed = true;
                break;
            }
            
            if (!destroyed) {
                st.push(asteroid);
            }
        }
        
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
