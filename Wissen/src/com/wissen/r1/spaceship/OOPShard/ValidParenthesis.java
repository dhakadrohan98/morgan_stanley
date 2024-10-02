//package com.wissen.r1.spaceship;
//
//import java.util.*;
//
//public class ValidParenthesis {
//
//	public static void main(String[] args) {
//		String str = "{([])}"; 
//		System.out.println(isMatched(str));
//
//	}
//
//	public static boolean isMatched(String str){ 
//		 
//        Stack<Character> stack = new Stack<>(); 
//        char[] charArray = str.toCharArray(); 
//
// 
//        for(char c : charArray){ 
//        	if(c =='{' ||c =='('||c =='['){ 
//        		stack.push(c); 
//        	}else if (c =='}' ||c ==')'||c ==']'){ 
//        		if(stack.isEmpty()){ 
//        			return false; 
//          } 
//
//      char top = stack.pop(); 
//
//      if((c==')' && top != '(') ||(c=='}' && top !='{') ||(c==']' && top != '[') ){ 
//          return false; 
//      } 
//    } 
//
//    } 
//
//    return stack.isEmpty(); 
//
//  }
//
//}
package com.wissen.r1.spaceship.OOPShard;


