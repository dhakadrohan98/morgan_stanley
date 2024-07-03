package com.wissen.streamAPI;

import java.util.*;
import java.util.stream.*;

public class OddNumbersSquares {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(23,1,21,54,64,36,45,78,69,79,5,4,101);
		list = list.stream().filter(n -> n%2 != 0).map(n -> n*n).collect(Collectors.toList());
		System.out.println(list);

	}

}
