package com.wissen.streamAPI;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class PredicateExampleSquareOfEvenNumbers {

	//In Java’s Stream API, a Predicate is a functional interface that represents a boolean-valued 
	//function. It takes an input and returns either true or false
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		 
		// Predicate to check if a number is even
		Predicate<Integer> predicate = n -> n % 2 == 0;
		
		// Using the predicate to filter even numbers from the list
		List<Integer> collect = list
		.stream()
		.filter(predicate) //using predicate here
		.map(n -> n*n)
		.collect(Collectors.toList());
		
		System.out.println(collect);
		
		

	}

}
