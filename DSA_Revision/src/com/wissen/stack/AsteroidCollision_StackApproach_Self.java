package com.wissen.stack;

import java.util.*;

public class AsteroidCollision_StackApproach_Self {
	
	//80_275 test cases has been passed
	//TC: O(n)
	//SC: O(n)
	public int[] asteroidCollision(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<Integer>();
        List<Integer> ds = new ArrayList<>();
        st.push(arr[0]);
        int i=1;
        while(i < n) {
            //collision will occur
            if(!st.isEmpty() && st.peek() > 0 && arr[i] < 0) {
                int first = st.peek();
                int left = Math.abs(first);
                int second = arr[i];
                int right = Math.abs(second);
                //right side asteroid will destroy
                if(left > right) {
                    ds.add(first);
                    st.pop();
                    i++;
                }
                //left side asteroid will destroy
                else if(left < right) {
                    while(!st.isEmpty() && first > second && left < right) {
                        st.pop();
                        first = st.peek();
                        left = Math.abs(first);
                    }
                    if(!st.isEmpty()) {
                        ds.add(first);
                        st.pop();
                        i++;
                    }
                }
                //both asteroid will destroy
                else { // left == right
                    st.pop();
                    i++;
                }
                
            }
            //collision will not occur
            else {
                st.push(arr[i]);
                i++;
            }
        }
        
        while(!st.isEmpty()) {
            ds.add(st.pop());
        }
        
        Collections.reverse(ds);
            
        int[] res = new int[ds.size()];
        for(int k=0; k < res.length; k++) {
            res[k] = ds.get(k);
        }
        
        return res; 
    }
}
