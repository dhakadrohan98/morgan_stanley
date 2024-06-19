package com.wissen.blind75;

import java.util.*;

public class RemoveOutermostParenthesis {

	//TC: O(n)
    //SC: O(n)
    public String removeOuterParentheses(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
               if(st.size() > 0) {
                    sb.append(ch);
                }
                st.push(ch);
            }
            else {
                st.pop();
                if(st.size() > 0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
