package com.wissen.stream.API;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWordFromStringUsingStreamAPI {

	public static void main(String[] args) {
		String str = "The quickusu brown fox jumps over the lazy dog";
		String longestWord = Arrays.stream(str.split(" ")).max(Comparator.comparing(n -> n.length())).orElse(null);
		System.out.println(longestWord);
	}

}
