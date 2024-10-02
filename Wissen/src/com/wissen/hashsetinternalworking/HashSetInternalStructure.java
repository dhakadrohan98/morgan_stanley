package com.wissen.hashsetinternalworking;

import java.util.HashMap;

public class HashSetInternalStructure {
	 // A HashMap object 
    private transient HashMap map;

    // A Dummy value(PRESENT) to associate with an Object in the Map
    private static final Object PRESENT = new Object();
    
    // default constructor of HashSet class
    // It creates a HashMap by calling 
    // default constructor of HashMap class
    public HashSetInternalStructure() {
        map = new HashMap<>();
    }

    // add method 
    // it calls put() method on map object
    // and then compares it's return value with null
    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
 
    // Other methods in Hash Set
}
