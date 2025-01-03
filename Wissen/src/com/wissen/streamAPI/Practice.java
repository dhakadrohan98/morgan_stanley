package com.wissen.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,91,2,3,4,1,2,3,1,4,5);
		
		list = list.stream().filter(n -> n%2!=0).map(n-> n*n).collect(Collectors.toList());
		System.out.println(list);

	}

}
