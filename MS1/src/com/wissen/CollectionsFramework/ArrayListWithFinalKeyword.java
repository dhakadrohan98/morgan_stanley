package com.wissen.CollectionsFramework;

import java.util.ArrayList;
import java.util.List;



public class ArrayListWithFinalKeyword {

	public static void main(String[] args) {
		final List<String> list = new ArrayList<>();
		list.add("John");
		list.add("Mike");
		list.add("Mike");
		System.out.println(list);
		list.add("Rohan");
		System.out.println(list);
		

	}

}
