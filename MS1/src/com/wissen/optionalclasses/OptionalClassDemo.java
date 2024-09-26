package com.wissen.optionalclasses;

import java.util.Optional;

public class OptionalClassDemo {

	public static void main(String[] args) {
		String[] words = new String[10];
		Optional<String> checkNull = Optional.ofNullable(words[5]);
		System.out.println(checkNull);
		
		if(checkNull.isPresent()) { //return true if checkNull is value otherwise false
	        String word = words[5].toLowerCase(); // NullPointerException
	        System.out.println(word);
		} else {
			System.out.println("word is null");
		}
		
		String isValue = Optional.ofNullable(words[5]).orElse("String is not present at 5th index");
		System.out.println(isValue);

	}

}
