package com.wissen.Iterator;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeExample {
	public static void main(String[] args) {
		
        ConcurrentHashMap<String, String> cityCode = new ConcurrentHashMap<>();
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
