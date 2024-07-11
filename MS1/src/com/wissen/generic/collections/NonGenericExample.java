package com.wissen.generic.collections;

import java.util.ArrayList;
import java.util.List;

public class NonGenericExample {
	//use any king of data types in collections is called non-generic.
	public static void main(String[] args) {
		List list = new ArrayList<>();
		
		list.add("string");
		list.add(1);
		list.add(1.2f);
		list.add(20000000000000l);
		System.out.println(list);

	}

}
