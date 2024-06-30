package com.wissen.blind75;

import java.util.*;

public class RemoveOutermostParenthesisV_1 {
	
	public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i=0, n = s.length();
        while(i < n) {
            char ch = s.charAt(i);
            //if current character is opening bracket then first check & then push
            if(ch == '(' ) {
                if(st.size() > 0) {
                    sb.append(ch);
                }
                st.push(ch);
            }
            //if current character is closing bracket then first pop & then check
            else {
                char outch = st.pop();
                if(st.size() > 0) {
                    sb.append(ch);
                }
            }
            i++;
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
