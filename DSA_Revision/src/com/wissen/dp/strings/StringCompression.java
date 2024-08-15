package com.wissen.dp.strings;

import java.util.Arrays;

public class StringCompression {

	//TC: O(n)
	//SC: O(1)
	public static int compress(char[] chars) {
		int n = chars.length;
		int i = 0;
		for (int j = 1, count = 1; j <= n; j++, count++) {
			if (j == n || (chars[j] != chars[j - 1])) {
				chars[i] = chars[j - 1];
				i++;
				if (count >= 2) {
					String itr = String.valueOf(count);
					for (char ch : itr.toCharArray()) {
						chars[i] = ch;
						i++;
					}
					// resetting count to 0, when it will reach to for loop,
					// it will be incremented by 1
				}
				count = 0;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		char[] chars1 = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
		char[] chars2 = { 'a', 'a', 'a', 'b', 'b', 'a', 'a' };
		System.out.println(compress(chars2));
		System.out.println(Arrays.toString(chars2));

	}
}

// 8_76 test cases are passed

//public static int compress(char[] chars) {
//    int n = chars.length;
//    if(n == 1) {
//    	return 1;
//    }
//    
//    int i=0;
//    int j=0;
//    while(i < n && j < n) {
//        
//        if((j < n-1) && chars[j] == chars[j+1]) {
//            j++;
//        } 
//        else if((j >= n-1) || (j < n-1 && chars[j] != chars[j+1])) {
//            int len = j-i+1;
//            if(len > 1 && len <= 9) {
//            	chars[i+1] = (char)(len+'0');
//            	System.out.println("j " + (j+1) + " i " + (i));
//                j=j+1;
//                i=j;
//            } 
//            else if(len == 1) {
//                i++;
//                j++;
//            }
//            else {
//                int num = len;
//                while((num/10) != 0) {
//                    chars[i+1] = (char)((num/10)+'0');
//                    num = num%10;
//                    i++;
//                }
//                //if(1/10 == 0)
//                chars[i+1] = (char)((num%10)+'0');
//                i = i + 2;
//                j = i;
//                break;
//            }
//            
//            //move i & j carefully
////            j = j+1;
////            i = j;
//        }
//        
//    }
//    
//    if(i >= n) {
//    	return i-1;
//    } else {
//    	return i;
//    }
//}
