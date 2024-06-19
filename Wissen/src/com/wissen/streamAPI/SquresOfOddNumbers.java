package com.wissen.streamAPI;

import java.util.*;
import java.util.stream.*;

public class SquresOfOddNumbers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,89,3,3,343,34,2,2145,2,34,3,11);
		list = list.stream().filter(n -> n%2 != 0).map(n-> n*n).collect(Collectors.toList());
		System.out.println(list);
		

	}

}
