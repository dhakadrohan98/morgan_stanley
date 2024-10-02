package com.wissen.r1.spaceship.OOPShard;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayFlattener {
	public static void main(String[] args) {
        List<Object> input = List.of(List.of(List.of(1), 2), List.of(3, 4));

//        List<Integer> flattened = flattenArray(input);

        System.out.println(input);
    }

//    public static List<Integer> flattenArray(List<Object> nestedList) {
//        return nestedList.stream()
//                .flatMap(item -> return flattenArray((List<Object>) item).stream();)
//                .collect(Collectors.toList());
//    }
}
