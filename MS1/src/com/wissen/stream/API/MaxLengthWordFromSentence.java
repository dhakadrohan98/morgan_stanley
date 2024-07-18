package com.wissen.stream.API;

import java.util.Arrays;

public class MaxLengthWordFromSentence {

	public static void main(String[] args) {
		String sen = "A simple sentence consists of just one independent clause a group of words "
				+ "that contains at least one subject and at least one verb and can stand alone as a "
				+ "complete sentence";
		
		String[] strArr = sen.split(" ");
		String longestWord = Arrays.stream(strArr).max((w1,w2) -> w1.length() - w2.length()).orElse("");
		System.out.println(longestWord);
	}
}