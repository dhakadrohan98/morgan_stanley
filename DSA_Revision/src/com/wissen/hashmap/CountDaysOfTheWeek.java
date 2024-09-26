package com.wissen.hashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountDaysOfTheWeek {

	//TC: O(n) -> n -> totalDays
	//SC: O(7+7) constant due to arr & Map
	public static Map<String, Integer> countDaysOfWeek(int totalDays, String firstDay) {
		//weekDays indexes are 0, 1,2,..
		//                     su,m,tu..
		int[] arr = new int[7];
		
		//calculate first day index
		int firstDayIndex = -1;
		if(firstDay.equalsIgnoreCase("sunday")) {
			firstDayIndex = 0;
		} else if(firstDay.equalsIgnoreCase("monday")) {
			firstDayIndex = 1;
		} else if(firstDay.equals("tuesday")) {
			firstDayIndex = 2;
		} else if(firstDay.equalsIgnoreCase("wednesday")) {
			firstDayIndex = 3;
		} else if(firstDay.equalsIgnoreCase("thrusday")) {
			firstDayIndex = 4;
		} else if(firstDay.equalsIgnoreCase("friday")) {
			firstDayIndex = 5;
		} else if(firstDay.equalsIgnoreCase("satuarday")) {
			firstDayIndex = 6;
		}
		
		int counter = 0;
		while(counter < totalDays) {
			int desiredIndex = firstDayIndex % 7;
			arr[desiredIndex] += 1;
			firstDayIndex++;
			counter++;
		}
		
//		for(int val : arr) {
//			System.out.print(val +" ");
//		}
//		System.out.println();	
		
		//make a hashmap containing all weekdays wi
		String[] weekDays = {"sunday", "monday", "tuesday", "wednesday", "thrusday", "friday", "satuarday"};
		Map<String, Integer> hmap = new LinkedHashMap<String, Integer>();
		int indx = 0;
		for(String days: weekDays) {
			hmap.put(days, arr[indx++]);
		}
		
		return hmap;
	}
	
	public static void main(String[] args) {
		int totalDays = 10;
		String firstDayOfWeek = "Wednesday";
		Map<String, Integer> countDaysOfWeek = countDaysOfWeek(totalDays, firstDayOfWeek);
		System.out.println(countDaysOfWeek);

	}

}
