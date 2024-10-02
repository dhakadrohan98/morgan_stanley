package com.wissen.Iterator;

import java.util.*;

public class FailFastExample {
	
	public static void main(String[] args) {
        Map<String, String> cityCode = new HashMap<>();
        cityCode.put("Delhi", "India");
        cityCode.put("Moscow", "Russia");
        cityCode.put("New York", "USA");

        Iterator<String> iterator = cityCode.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(cityCode.get(iterator.next()));
            //Adding new key into the map
            // Structural modification of the map
//            cityCode.put("Istanbul", "Turkey");
            //Updating existing key
            cityCode.put("New York", "Canada");
        }
        
        StringBuilder
    }

}
