package com.wissen.string.immutable.methods;

public class StringInternExample {

	public static void main(String[] args) {
		String str1 = new String("Welcome to JavaTpoint").intern();   
		String str2 = new String("Welcome to JavaTpoint").intern();
		System.out.println(str1 == str2); // prints true  

	}

}
