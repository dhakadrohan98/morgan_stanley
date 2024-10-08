package com.wissen.r1.spaceship.OOPShard;

import java.util.*;

public class FlatternArray {
	public static void main(String[] args) {
        // Example input
        List<Object> input = new ArrayList<>();
        input.add(new ArrayList<>(List.of(1)));
        input.add(2);
        input.add(new ArrayList<>(List.of(3, 4)));
        input.add(new ArrayList<>(new ArrayList<>(new ArrayList<>(List.of(5, 6)))));
        System.out.println(input);
        
        //Sample input 2:
//        { 1, 2, new Object[]{ 3, 4, new Object[]{ 5, new Object[]{ 13,45,65} }, 6, 7 }, 8, 9, 10 };

        // Flatten the array
        List<Integer> output = flattenArray(input);

        // Print the flattened array
        System.out.println(output);
	}
	
	public static List<Integer> flattenArray(List<Object> arr) {
        List<Integer> result = new ArrayList<>();
        for (Object item : arr) {
            if (item instanceof List) {
                result.addAll(flattenArray((List<Object>) item));
            } else if (item instanceof Integer) {
                result.add((Integer) item);
            }
        }
        return result;
    }
}
