package com.wissen.stream.api;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.*;

public class FirstNonRepeatingCharacters {

	public static char nonrepeatingCharacter(String S) {
		return S.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No non-repeating character found"));
	}

	public static void main(String[] args) {
		String S = "swiswsier";
		System.out.println("First non-repeating character: " + nonrepeatingCharacter(S));

	}

}

//candidate code:
//	
//	public static char nonrepeatingCharacter(String S) {
//	return S.chars().mapToObj(c -> (char) c)
//			.collect(Collectors
//					.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//			.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getkey()).findFirst().get();
//}
