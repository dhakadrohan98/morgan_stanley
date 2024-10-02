package com.wissen.DSAproblems;

public class ConvertIntoUppercase_Separated {

	public static void main(String[] args) {
		String str = "iAmGoingThere";
		
		String regex = "([a-z])([A-Z])";
		String replacement = "$1_$2";
		
		str = str.replaceAll(regex, replacement).toUpperCase();
		System.out.println(str);

	}

}
