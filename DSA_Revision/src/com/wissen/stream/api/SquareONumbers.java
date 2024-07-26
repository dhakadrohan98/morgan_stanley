package com.wissen.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareONumbers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,4,23,21,45,43,36,47,13,17,18,19,33);
		List<Integer> res = list.stream().filter(n -> n%2 != 0).map(n -> n*n).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(res);

	}

}
