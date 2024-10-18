package com.wissen.hashmap;

import java.util.*;
public class CountDaysOfTheWeek_1 {

	public static Map<String, Integer> countDaysOfTheWeek(int totalDays, String firstDayOfWeek) {
		int[] week = new int[7];
		firstDayOfWeek = firstDayOfWeek.toLowerCase();
		int startIndex = -1;
		if(firstDayOfWeek.equals("sunday")) {
			week[0] = 1;
			startIndex = 0;
		} else if(firstDayOfWeek.equals("monday")) {
			week[1] = 1;
			startIndex = 1;
		} else if(firstDayOfWeek.equals("tuesday")) {
			week[2] = 1;
			startIndex = 2;
		} else if(firstDayOfWeek.equals("wednesday")) {
			week[3] = 1;
			startIndex = 3;
		} else if(firstDayOfWeek.equals("thrusday")) {
			week[4] = 1;
			startIndex = 4;
		} else if(firstDayOfWeek.equals("friday")) {
			week[5] = 1;
			startIndex = 5;
		} else {
			week[6] = 1;
			startIndex = 6;
		}
		
		Map<String, Integer> lhmap = new LinkedHashMap<>();
		startIndex += 1;
		int days = 1;
		
		while(days < totalDays) {
			week[startIndex % 7] += 1;
			startIndex++;
			days++;
		}
		
		//print week array
		for(int val : week) {
			System.out.print(val + " ");
		}
		System.out.println();
		
		//constant time
		lhmap.put("sunday", week[0]);
		lhmap.put("monday", week[1]);
		lhmap.put("tuesday", week[2]);
		lhmap.put("wednesday", week[3]);
		lhmap.put("thrusday", week[4]);
		lhmap.put("friday", week[5]);
		lhmap.put("satuarday", week[6]);
		
		return lhmap;
	}
	
	public static void main(String[] args) {
		int totalDays = 15;
		String firstDay = "Wednesday";
		Map<String, Integer> lhmap = countDaysOfTheWeek(totalDays, firstDay);
		System.out.println(lhmap);
	}

}
