package com.wissen.stream.API;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWordFromStringUsingStreamAPI {

	public static void main(String[] args) {
		String str = "The quickusu brown fox jumps over the lazy dog";
		String longestWord = Arrays.stream(str.split(" ")).max((n1,n2) -> n1.length()-n2.length()).orElse(null);
		System.out.println(longestWord);
	}

}
