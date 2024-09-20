package com.wissen.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	//TC: O(nlogn * K),  k-> is no. of characters compared lexicograhically in compare() method
	//SC: O(2n) + O(n) due to Timsort
	public String largestNumber(int[] nums) {
		int n = nums.length;
        String elements[] = new String[n];
        //TC: O(n)
        for(int i=0;i<n;i++){
            elements[i] = Integer.toString(nums[i]);
        }
        // TC: O(nlogn * K),  k-> is no. of characters compared lexicograhically in compare() method
        Arrays.sort(elements, new Comparator<String>(){
            public int compare(String a, String b){
                String first = a + b;
                String sec = b + a;
                return sec.compareTo(first); //K
            }
        });
        
        //edge case if there are more than more 0's in array, then return only 0
        if(elements[0].equals("0")){
            return "0";
        }
        
        // TC: O(n)
        StringBuilder sb = new StringBuilder();
        for(String val : elements){
            sb.append(val);
        }
        return sb.toString();
	}

	public static void main(String[] args) {
		//Compare two string in a lexicograhical Order
		String num1 = "303";
		String num2 = "330";
		System.out.println(num2.compareTo(num1));
	}

}
