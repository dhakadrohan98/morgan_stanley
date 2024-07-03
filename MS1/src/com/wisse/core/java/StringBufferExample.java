package com.wisse.core.java;

public class StringBufferExample {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();

		// Append a string to the StringBuffer
		sb.append("Hello, world!");
		System.out.println(sb);
		
		// Replace a character in the StringBuffer
		sb.replace(0, 5, "Goodbye");

		// Get the contents of the StringBuffer as a string
		String str = sb.toString();

		// Print the string to the console
		System.out.println(str);
		
		StringBuffer sb1 = new StringBuffer("Hello ");
        sb1.insert(1, "Java");
        // Now original string is changed
        System.out.println(sb1);
	}

}
