package com.wissen.hashsetinternalworking;

import java.util.HashSet;

public class HashSetAddMethodInternalWorking {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		boolean b1 = set.add("Geeks");
		boolean b2 = set.add("GeeksForGeeks");
		boolean b3 = set.add("Geeks");
		
		  // printing b1, b2, b3 
        System.out.println("b1 = "+b1); 
        System.out.println("b2 = "+b2); 
        System.out.println("b3 = "+b3); 
          
        // printing all elements of hashset 
        System.out.println(set); 
	}
}
