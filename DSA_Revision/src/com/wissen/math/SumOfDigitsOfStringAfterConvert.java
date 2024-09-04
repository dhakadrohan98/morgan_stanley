package com.wissen.math;

public class SumOfDigitsOfStringAfterConvert {
	//TC: << O(k*n)
	//SC: O(n)
	public static int getLucky(String s, int k) {
		String str = "";
        for(char ch : s.toCharArray()) {
            int digit = (ch - 'a') + 1;
            str += digit;
        }
        System.out.println(str);
        
        int sum = 0;
        while(k > 0) {
            for(int i=0; i<str.length(); i++) {
            	char ch = str.charAt(i);
            	//get numeric value for curr char num
            	int digit = ch - '0';
                sum += digit;    
            }
            System.out.println(sum);
            str = sum+"";
            sum = 0;
            k--;
        }
        
        
        return Integer.parseInt(str);
	}
	public static void main(String[] args) {
		String str = "zbax";
		int k = 2 ;
		
		String str1 = "dbvmfhnttvr";
		int k1 = 5;
		int lucky = getLucky(str1, k1);
		System.out.println(lucky);
		

	}

}
