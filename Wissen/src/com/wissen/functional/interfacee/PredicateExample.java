package com.wissen.functional.interfacee;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<String> isEmpty = String::isEmpty;
        System.out.println("Is empty: " + isEmpty.test(""));

	}

}
