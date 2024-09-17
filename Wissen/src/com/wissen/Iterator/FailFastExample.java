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
            // Structural modification of the map
            cityCode.put("Istanbul", "Turkey");
        }
    }

}
