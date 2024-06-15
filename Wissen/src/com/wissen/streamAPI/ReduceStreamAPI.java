package com.wissen.streamAPI;

import java.util.*;

public class ReduceStreamAPI {

	public static void main(String[] args) {
		List<Integer> number = Arrays.asList(2,3,4,5,7,8);
		int even = (int) number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
		System.out.println(even);

	}

}
