package com.wissen.math;

import java.util.*;

public class FractionToRecurringDecimal1 {

	// 39/39 test cases passed
	public static String fractionToDecimal(int num1, int den1) {
		StringBuilder sb = new StringBuilder();
		Map<Long, Integer> hmap = new HashMap<>();
		boolean isDot = false;
		boolean isNegative = false;;
		long repeatRem = 0;

		//for negative numbers check
		if(num1 == 0) {
			return "0";
		} else if(num1 < 0 && den1 < 0) {
			//ans string will be +ve
		} else if(num1 < 0 || den1 < 0) {
			isNegative = true;
		}
		long num = Math.abs((long) num1);
        long den = Math.abs((long) den1);
            
		long quot = num / den;
		long rem = num % den;
		if (rem == 0) {
			sb.append(quot);
		} else {
			sb.append(quot);
			sb.append(".");
//			list.add(sb.length());
			// while rem starts repeating or becomes zero
			while (rem != 0) {
				num = rem * 10;
				// special case for 0 repetition	
				quot = num / den;
				sb.append(quot);
				rem = num % den;
				if (hmap.containsKey(rem)) {
					repeatRem = rem;
					sb.append(")");
					break;
				} else {
					hmap.put(rem, sb.length());
				}
			}

		}
		//if there were repetition in quotient in case of non zero rem
		if (sb.toString().contains(')' + "")) {
			int pos = hmap.get(repeatRem);
			sb.insert(pos, '(');
		}
		
		if(isNegative == true) {
			sb.insert(0,'-');
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int num1 = 37;
		int den1 = 2;
		int num2 = 428;
		int den2 = 125;
		int num3 = 4;
		int den3 = 333;
		int num4 = 	1;
		int den4 = 6;
		
		int num5 = -50;
		int den5 = 8;
		
		int num6 = 0;
		int den6 = -5;
		
		int num7 = 7;
		int den7 = -12;
		
		String res = fractionToDecimal(num7, den7);
		System.out.println(res);

	}

}


// special case
//while (num < den) {
//	if (hmap.containsKey(0)) {
//		isOuter = true;
//		sb.append(")");
//		break;
//	} else {
//		hmap.put(0, sb.length());
//	}
////	hmap.put(0, true);
//	sb.append("0");
//	num = num * 10;
//}
