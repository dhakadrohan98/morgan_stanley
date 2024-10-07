package com.wissen.CollectionsFramework;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LinkedListCollectionMethods {

	public static void main(String[] args) {
		List<Integer> ll = new LinkedList<>();
		ll.add(21);
		ll.add(33);
		System.out.println(ll);
		ll.remove(0);
		System.out.println(ll);
		
		
		Deque<Integer> linkedlist = new LinkedList<>();
		linkedlist.offerFirst(1);
		linkedlist.offerFirst(2);
		System.out.println(linkedlist);
		
	}

}
