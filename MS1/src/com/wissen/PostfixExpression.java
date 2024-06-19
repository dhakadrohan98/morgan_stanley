package com.wissen;

import java.util.*;

public class PostfixExpression {

	//Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s)
    {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(ch == '+') {
                int second = st.pop();
                int first = st.pop();
                int res = first + second;
                st.push(res);
            } else  if(ch == '-') {
                int second = st.pop();
                int first = st.pop();
                int res = first - second;
                st.push(res);
            } else  if(ch == '*') {
                int second = st.pop();
                int first = st.pop();
                int res = first * second;
                st.push(res);
            } else  if(ch == '/') {
                int second = st.pop();
                int first = st.pop();
                int res = first / second;
                st.push(res);
            }
            //current character is number
            else {
                int num = ch - '0';
                st.push(num);
            }
        }
        System.out.println("ASCII of '0': "+(int)'0');
        return st.pop();
    }
    
	public static void main(String[] args) {
		String s = "231*+9-";
		System.out.println(evaluatePostFix(s));

	}

}
