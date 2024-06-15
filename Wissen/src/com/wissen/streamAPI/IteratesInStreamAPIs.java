package com.wissen.streamAPI;

import java.util.*;

public class IteratesInStreamAPIs {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(2,3,4,5);
		numbers.stream().map(n -> n*n).forEach(n -> {System.out.print(n + " ");});
	}

}
