package com.wissen.functional.interfacee;

import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringToUppercase_FunctionInterfaceExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("alice", "bob", "charlie");

		// Function to convert a string to uppercase
		Function<String, String> toUpperCase = String::toUpperCase;
		
		//applying the function to the list of names
		List<String> upperCaseName = names
				.stream()
				.map(toUpperCase)
				.collect(Collectors.toList());
		
		System.out.println(upperCaseName);
		
	}

}
