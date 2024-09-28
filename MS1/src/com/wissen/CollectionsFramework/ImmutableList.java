package com.wissen.CollectionsFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * if you assign Collecons.unmodifiableList (list); to a new reference
	then you will be able to change the original list which will in turn change
	the new list also
 */

//public static void main(String[] args) {
//	List<String> list = new ArrayList<>();
//	list.add("John");
//	list.add("Mike");
//	list.add("Mike");
//	System.out.println("Original list: " + list);
//	List<String> newList = Collections.unmodifiableList(list);
//	list.add("Rohan");
//	System.out.println("Original list: " + list);
//	System.out.println("New list: " + newList);
//
//}

public class ImmutableList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("John");
		list.add("Mike");
		list.add("Mike");
		System.out.println(list);
		List<String> anotherList = Collections.unmodifiableList(list);
		anotherList.add("Rohan");
	}

}
