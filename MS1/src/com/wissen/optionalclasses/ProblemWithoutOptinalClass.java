package com.wissen.optionalclasses;

public class ProblemWithoutOptinalClass {

	public static void main(String[] args) {
		String[] words = new String[10];
        String word = words[5].toLowerCase(); // NullPointerException
        System.out.print(word);

	}

}
