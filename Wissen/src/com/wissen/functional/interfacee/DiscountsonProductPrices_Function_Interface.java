package com.wissen.functional.interfacee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class DiscountsonProductPrices_Function_Interface {

	// bbhaihrhia
	public static int firstNonRepeatingCharIndex(String str) {
		Map<Character, Integer> hmap = new HashMap<>();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			hmap.put(ch, hmap.getOrDefault(ch, 0)+1);
		}
		
		for(int i=0; i< str.length(); i++) {
			char ch = str.charAt(i);
			if(hmap.get(ch) == 1) {
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		
		
		
		List<Double> prices = Arrays.asList(100.0, 200.0, 300.0);

		// Function to apply a 10% discount
		Function<Double, Double> applyDiscount = price -> price * 0.9;

		// Applying the function to the list of prices
		List<Double> discountedPrices = prices.stream().map(applyDiscount).collect(Collectors.toList());

		System.out.println(discountedPrices); // Output: [90.0, 180.0, 270.0]
	}
}
