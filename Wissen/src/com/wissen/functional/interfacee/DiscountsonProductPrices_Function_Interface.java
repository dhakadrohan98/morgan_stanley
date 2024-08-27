package com.wissen.functional.interfacee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class DiscountsonProductPrices_Function_Interface {
	public static void main(String[] args) {
		List<Double> prices = Arrays.asList(100.0, 200.0, 300.0);

		// Function to apply a 10% discount
		Function<Double, Double> applyDiscount = price -> price * 0.9;

		// Applying the function to the list of prices
		List<Double> discountedPrices = prices.stream().map(applyDiscount).collect(Collectors.toList());

		System.out.println(discountedPrices); // Output: [90.0, 180.0, 270.0]
	}
}
