package com.wissen.CollectionsFramework;

import java.util.*;

/**
 * Collection -> Interface extends Iterable interface and it is a framework that provides an 
 * architecture to store and manipulate a group of objects.
 */
public class ArrayListCapacity {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>(15);
		list.ensureCapacity(50);
	
	}

}
