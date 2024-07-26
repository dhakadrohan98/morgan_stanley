package com.wissen.stream.api;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Stream;

public class MaxLengthWordFromSentenceUsingStreamAPI {

	public static void main(String[] args) {
		String sen = "A simple sentence consists of just one independent clause a group of words "
				+ "that contains at least one subject and at least one verb and can stand alone as a "
				+ "complete sentence";
		
		String maxLengthWord = Arrays.stream(sen.split(" ")).max((s1,s2) -> s1.length() - s2.length()).orElse(null);
		System.out.println(maxLengthWord);
	}

}
