package com.wissen.stack;

import java.util.*;

//TC: O(1) 
//SC: O(N) storing some original & some modified value once

public class MinStackDesign {
	Stack<Long> st= new Stack<Long>();
    Long mini;
    //Initializ minimal with max value
    public MinStackDesign() {
        mini = Long.MAX_VALUE;
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);
        if(st.isEmpty()) { //push the first element
            mini = val;
            st.push(val);
        } else {
          if(val < mini) {
              //push modified value (from rollBack() purpose) & curr val will be curr minimal.
              st.push(2*val - mini);
              mini = val;
          } else {
              st.push(val);
          }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) {
            return;
        }
        Long val = st.pop();
        if(val < mini) { //modified value is present at the top of the stack    
            //rollBack curr minimal to prev minimal
            mini = 2 * mini - val;
        }
    }
    
    public int top() {
        Long val = st.peek();
        if(val < mini) { //if there is modified value at the top then return curr minimal. Otherwise return top of the stack as it is the original values being pushed previously in push()   operation.
            return mini.intValue();
        } 
        return val.intValue();
    }
    
    public int getMin() {
        return mini.intValue();
    }
}

//Test cases
// 1. i/p:
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]
// o/p: [null,null,null,null,-3,null,0,-2]
