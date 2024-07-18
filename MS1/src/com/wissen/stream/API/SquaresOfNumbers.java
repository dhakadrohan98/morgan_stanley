package com.wissen.stream.API;

import java.util.*;
import java.util.stream.Collectors;

public class SquaresOfNumbers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,45,34,64,12,23,34,45,67,7,87,78,89,99,104);
		
		list = list.stream().filter(n -> n%2 != 0).map(n -> n*n).collect(Collectors.toList());
		System.out.println(list);

	}

}
