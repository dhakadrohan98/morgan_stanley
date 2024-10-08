package com.wissen.Iterator;

import java.util.*;
import java.util.concurrent.*;

public class RemoveElementFromListUsingIterator {
	
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(7);
		list.add(9);
		list.add(34);
		list.add(23);
		list.add(47);
		list.add(17);
		System.out.println("size: " +list.size());
		
		Iterator<Integer> itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
			//This method can be called only once per call to next. 
			itr.remove();
			System.out.println("size: " + list.size());
		}
	}

}
