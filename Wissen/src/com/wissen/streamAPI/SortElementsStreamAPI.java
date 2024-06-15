package com.wissen.streamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class SortElementsStreamAPI {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("computer", "Reflection","Collection","Stream");
		System.out.println("before sorting");
		System.out.println(names);
		//sorting will applied to according to ASCII values 
		names = names.stream().sorted().collect(Collectors.toList());
		System.out.println("after sorting");
		System.out.println(names);
		

	}

}
