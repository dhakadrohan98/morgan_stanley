package com.wissen.CollectionsFramework;

import java.util.*;

public class TreeSetImpl {

	public static void main(String[] args) {
		Set<String> t = new TreeSet<>();
        t.add("Java");  //Adding elements   
        t.add("Spring");   
        t.add("Hibernate");   
        // Duplicates elements are not allowed   
        t.add("Hibernate");   
        // By default, the elements will be sorted   
        // in Ascending order  
        System.out.println(t);   

	}

}
