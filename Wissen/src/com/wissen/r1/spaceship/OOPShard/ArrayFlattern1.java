//package com.wissen.r1.spaceship;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.*;
//
//public class ArrayFlattern1 {
//	
//    public static void main(String[] args) {
//        Object[] inputArray = new Object[] { new Object[] { new Object[] { 1 }, 2 }, new Object[] { 3, 4 } };
//        Integer[] flattenedArray = flatten(inputArray);
//        System.out.println(Arrays.toString(flattenedArray));
//    }
//
//    public static Integer[] flatten(Object[] inputArray) throws Exception {
//        return Arrays.stream(inputArray).flatMap(o -> o instanceof Object[] ? Arrays.stream((Object[]) o) : Stream.of(o)).flatMap(o -> o instanceof Integer ? Stream.of((Integer) o) : flatten((Object[]) o)).toArray(Integer[]::new);
//    }
//}
package com.wissen.r1.spaceship.OOPShard;


