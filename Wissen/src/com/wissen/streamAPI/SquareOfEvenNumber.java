package com.wissen.streamAPI;

import java.util.*;
//import java.util.stream.Collectors;
import java.util.stream.Collectors;

public class SquareOfEvenNumber {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,-4,5,-6,7,8,-9,10,-13,14,-15,16,17,18,20,21,22,23,24,28);
		list = list.stream().filter(n -> n<0).map(n-> n*n).collect(Collectors.toList());
		System.out.println(list);

	}

}
