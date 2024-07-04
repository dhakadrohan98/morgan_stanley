package com.wissen.StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumSalary {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,-9,11,111,13,15,14,18,16,19);
		int min = list.stream().min(Comparator.comparing(n -> n)).orElse(-1);
		System.out.println(min);
		
	}

}
